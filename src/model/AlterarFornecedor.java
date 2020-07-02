package model;

import java.awt.Color;
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

public class AlterarFornecedor extends JPanel {
	private JTextField nomeFornecedor;
	private JTextField email;
	private JTextField cnpj;
	private JTextField telefone;
	private JTextField bairro;
	private JTextField rua;
	private JTextField cep;
	private String nomeFornecedorBd, emailBd, cnpjBd, telefoneBd, cidadeBd, bairroBd, ruaBd, cepBd;
	private BD bd;
	/**
	 * Create the panel.
	 */
	public AlterarFornecedor(int idFornecedor) {
		bd = new BD();
		bd.getConnection();
		String sql = "SELECT * FROM fornecedores WHERE idFornecedor = " + idFornecedor;
		
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execuï¿½ï¿½o
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			nomeFornecedorBd =  bd.rs.getString("nomeFornecedor");
			emailBd = bd.rs.getString("email");
			cnpjBd =  bd.rs.getString("cnpj");
			telefoneBd =  bd.rs.getString("telefone");
			cidadeBd = bd.rs.getString("cidade");
			bairroBd = bd.rs.getString("bairro");
			ruaBd = bd.rs.getString("endereco");
			cepBd = bd.rs.getString("cep");
			bd.close();
		} catch( SQLException error ) {
			System.out.println("ERRO => " + error);
		}
		
		setLayout(null);
		setBounds(100, 100, 481, 290);

		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		nomeFornecedor = new JTextField();
		nomeFornecedor.setText(nomeFornecedorBd);
		nomeFornecedor.setColumns(10);
		nomeFornecedor.setBounds(110, 23, 214, 20);
		add(nomeFornecedor);
		
		email = new JTextField();
		email.setText(emailBd);
		email.setColumns(10);
		email.setBounds(110, 54, 214, 20);
		add(email);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(57, 23, 43, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(55, 54, 46, 14);
		add(lblNewLabel_2);
	
		cnpj = new JTextField();
		cnpj.setText(cnpjBd);
		cnpj.setColumns(10);
		cnpj.setBounds(110, 82, 214, 20);
		add(cnpj);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ:");
		lblNewLabel_3.setBounds(59, 82, 36, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setBounds(41, 113, 55, 14);
		add(lblNewLabel_4);
		
		telefone = new JTextField();
		telefone.setText(telefoneBd);
		telefone.setColumns(10);
		telefone.setBounds(110, 113, 214, 20);
		add(telefone);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		lblNewLabel_5.setBounds(51, 144, 42, 14);
		add(lblNewLabel_5);
		
		JComboBox cbCidade = new JComboBox();
		cbCidade.setModel(new DefaultComboBoxModel(new String[] {"Indaiatuba", "Campinas"}));
		cbCidade.setBounds(110, 143, 214, 22);
		add(cbCidade);
		
		bairro = new JTextField();
		bairro.setText(bairroBd);
		bairro.setColumns(10);
		bairro.setBounds(110, 176, 214, 20);
		add(bairro);
		
		JLabel lblNewLabel = new JLabel("Bairro:");
		lblNewLabel.setBounds(55, 176, 43, 14);
		add(lblNewLabel);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(68, 207, 32, 14);
		add(lblRua);
		
		rua = new JTextField();
		rua.setText(ruaBd);
		rua.setColumns(10);
		rua.setBounds(110, 207, 214, 20);
		add(rua);
		
		JLabel lblNewLabel_6 = new JLabel("CEP:");
		lblNewLabel_6.setBounds(67, 236, 33, 14);
		add(lblNewLabel_6);
		
		cep = new JTextField();
		cep.setText(cepBd);
		cep.setColumns(10);
		cep.setBounds(110, 236, 214, 20);
		add(cep);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idForn = idFornecedor;
				nomeFornecedorBd = nomeFornecedor.getText();
				emailBd = email.getText();
				cnpjBd = cnpj.getText();
				telefoneBd = telefone.getText();
				cidadeBd = (String) cbCidade.getSelectedItem();
				bairroBd = bairro.getText();
				ruaBd = rua.getText();
				cepBd = cep.getText();
				
				String sql = "UPDATE fornecedores SET nomeFornecedor = ?, cnpj = ?, endereco = ?, cidade = ?"
						+ ", bairro = ?, telefone = ?, email = ? , cep = ? "
						+ " WHERE idFornecedor = ?";
				
				System.out.println(sql);
				bd = new BD();
				bd.getConnection();
				try {
					
					bd.st = bd.con.prepareStatement(sql); //preparei a query para a execu��o
					bd.st.setString(1, nomeFornecedorBd);
					bd.st.setString(2, cnpjBd);
					bd.st.setString(3, ruaBd);
					bd.st.setString(4, cidadeBd);
					bd.st.setString(5, bairroBd);
					bd.st.setString(6, telefoneBd);
					bd.st.setString(7, emailBd);
					bd.st.setString(8, cepBd);
					bd.st.setInt(9, idFornecedor);
					
					System.out.println(sql);
					bd.st.executeUpdate();
//					descricao.setText("");
					nomeFornecedor.setText("");
					email.setText("");
					cnpj.setText("");
					telefone.setText("");
					//cbCidade.getSelectedItem();
					bairro.setText("");
					rua.setText("");
					cep.setText("");
					
					JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				} catch( SQLException error ) {
					System.out.println("ERRO => " + error);
					JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.setBounds(357, 196, 89, 23);
		add(btnSalvar);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarFornecedores checar = new ChecarFornecedores();
				Menu.atualizarPainel(checar);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AlterarFornecedor.class.getResource("/Imagens/Voltar.png")));
		btnNewButton_1.setBounds(359, 233, 87, 23);
		add(btnNewButton_1);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 290);
		add(planoFundo);

	}
}
