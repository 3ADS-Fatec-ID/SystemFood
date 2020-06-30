package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.BD;
import services.Criptografia;

public class CadastrarUsuario extends JPanel {
	private JTextField nomeUsuario;
	private JTextField senhaUsuario;
	public static BD bd;

	/**
	 * Create the panel.
	 */
	public CadastrarUsuario() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Usu\u00E1rio:");
		lblNewLabel.setBounds(110, 69, 108, 14);
		add(lblNewLabel);
		
		nomeUsuario = new JTextField();
		nomeUsuario.setColumns(10);
		nomeUsuario.setBounds(226, 66, 106, 20);
		add(nomeUsuario);	
		
		JLabel lblNewLabel_1 = new JLabel("Senha do Usu\u00E1rio:");
		lblNewLabel_1.setBounds(110, 106, 116, 14);
		add(lblNewLabel_1);
		
		senhaUsuario = new JTextField();
		senhaUsuario.setColumns(10);
		senhaUsuario.setBounds(226, 103, 106, 20);
		add(senhaUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("Permiss\u00E3o de Acesso:");
		lblNewLabel_1_1.setBounds(85, 143, 129, 14);
		add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));
		comboBox.setBounds(226, 140, 106, 20);
		add(comboBox);
		
		JButton btnSalvar = new JButton("Salvar Cadastro");
		btnSalvar.setBounds(207, 167, 145, 23);
		add(btnSalvar);
		
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
				
				bd = new BD();
				bd.getConnection();
				String sql = "INSERT INTO usuarios (email, senha, permissao)"
						+ " VALUES (?, ?, ?);";
					
				System.out.println(sql);
				
				try {
					
					if(nameUser != null && passUser != null && nameUser.length() != 0 && passUser.length() != 0) {
						bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
						bd.st.setString(1, nameUser);
						bd.st.setString(2, passUser);
						bd.st.setString(3, permission);
						bd.st.executeUpdate();
						nomeUsuario.setText("");
						senhaUsuario.setText("");
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
						
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				} catch( SQLException error ) {
					System.out.println("ERRO => " + error);
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);
		
		
		
		
	}
}
