package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import services.BD;
import services.Criptografia;

public class UsuarioDAO extends JPanel {

	private JTextField nomeUsuario;
	private JTextField senhaUsuario;
	public static BD bd;
	public int idUsuario;
	private String email;
	private String senha;
	private String permissao;

	/**
	 * Create the Panel.
	 */
	public UsuarioDAO(int idUsuario) {
		
		bd = new BD();
		bd.getConnection();
		String sql = "SELECT * FROM usuarios WHERE idUsuario = " + idUsuario;
		
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			email =  bd.rs.getString("email");
			senha =  bd.rs.getString("senha");
			permissao =  bd.rs.getString("permissao");
			System.out.println(email);
			System.out.println(senha);
			System.out.println(permissao);
			
		} catch( SQLException error ) {
			System.out.println("ERRO => " + error);
		}
		
		System.out.println(sql);
		
		setBounds(100, 100, 481, 289);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Usu\u00E1rio:");
		lblNewLabel.setBounds(109, 45, 108, 14);
		add(lblNewLabel);
		
		nomeUsuario = new JTextField();
		nomeUsuario.setText(email);
		nomeUsuario.setColumns(10);
		nomeUsuario.setBounds(225, 42, 106, 20);
		add(nomeUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Senha do Usu\u00E1rio:");
		lblNewLabel_1.setBounds(109, 82, 116, 14);
		add(lblNewLabel_1);
		
		senhaUsuario = new JTextField();
		senhaUsuario.setText(senha);
		senhaUsuario.setColumns(10);
		senhaUsuario.setBounds(225, 79, 106, 20);
		add(senhaUsuario);
		
		
		JComboBox comboBox = new JComboBox();
		System.out.println("PERMISSÃO => " + permissao);
		if(permissao.equals("admin")) {
			System.out.println("Administrador");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usu\u00E1rio"}));
			comboBox.setBounds(225, 116, 106, 20);
			add(comboBox);
		} else if(permissao.equals("user")) {
			System.out.println("Usu\\u00E1rio");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usu\u00E1rio", "Administrador"}));
			comboBox.setBounds(225, 116, 106, 20);
			add(comboBox);
		}
		
		JButton btnSalvar = new JButton("Salvar Altera\u00E7\u00F5es");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String nameUser = nomeUsuario.getText();
				String passUser = senhaUsuario.getText();
				String permission = (String) comboBox.getSelectedItem();
				if(permission == "Administrador") {
					System.out.println(nameUser + passUser + permission);
					permission = "admin";
				} else {
					permission = "user";
				}
				
				String sql = "UPDATE usuarios SET email = ?, senha = ?, permissao = ? WHERE idUsuario = ?";
				System.out.println(sql);
				
				try {
					
					if(nameUser != null && passUser != null && nameUser.length() != 0 && passUser.length() != 0) {
						bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
						bd.st.setString(1, nameUser);
						bd.st.setString(2, passUser);
						bd.st.setString(3, permission);
						bd.st.setInt(4, idUsuario);
						bd.st.executeUpdate(sql);
						nomeUsuario.setText("");
						senhaUsuario.setText("");
						JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				} catch( SQLException error ) {
					System.out.println("ERRO => " + error);
					JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSalvar.setBounds(206, 143, 145, 23);
		add(btnSalvar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Permiss\u00E3o de Acesso:");
		lblNewLabel_1_1.setBounds(84, 119, 129, 14);
		add(lblNewLabel_1_1);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarUsuarios checar = new ChecarUsuarios();
				Menu.atualizarPainel(checar);
			}
		});
		btnVoltar.setIcon(new ImageIcon(UsuarioDAO.class.getResource("/Imagens/Voltar.png")));
		btnVoltar.setBounds(57, 214, 87, 23);
		add(btnVoltar);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);
	}
}
