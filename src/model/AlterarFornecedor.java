package model;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import services.BD;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AlterarFornecedor extends JPanel {
	private JTextField nomeFornecedor;
	private JTextField email;
	private JTextField cnpj;
	private JTextField telefone;
	private JTextField bairro;
	private JTextField rua;
	private JTextField cep;
	private String nomeFornecedorBd, emailBd, cnpjBd, telefoneBd, bairroBd, ruaBd, cepBd;
	public BD bd;
	/**
	 * Create the panel.
	 */
	public AlterarFornecedor(int idFornecedor) {
		bd = new BD();
		bd.getConnection();
		String sql = "SELECT * FROM fornecedores WHERE idFornecedor = " + idFornecedor;
		
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			nomeFornecedorBd =  bd.rs.getString("nomeFornecedor");
			emailBd = bd.rs.getString("email");
			cnpjBd =  bd.rs.getString("telefone");
			telefoneBd =  bd.rs.getString("telefone");
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
		nomeFornecedor.setBounds(193, 23, 112, 20);
		add(nomeFornecedor);
		
		email = new JTextField();
		email.setText(emailBd);
		email.setColumns(10);
		email.setBounds(193, 54, 112, 20);
		add(email);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(150, 26, 43, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(148, 57, 46, 14);
		add(lblNewLabel_2);
	
		cnpj = new JTextField();
		cnpj.setText(cnpjBd);
		cnpj.setColumns(10);
		cnpj.setBounds(193, 82, 112, 20);
		add(cnpj);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ:");
		lblNewLabel_3.setBounds(152, 85, 36, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setBounds(134, 116, 55, 14);
		add(lblNewLabel_4);
		
		telefone = new JTextField();
		telefone.setText(telefoneBd);
		telefone.setColumns(10);
		telefone.setBounds(193, 113, 112, 20);
		add(telefone);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		lblNewLabel_5.setBounds(144, 147, 42, 14);
		add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Indaiatuba", "Campinas"}));
		comboBox.setBounds(193, 143, 112, 22);
		add(comboBox);
		
		bairro = new JTextField();
		bairro.setText(bairroBd);
		bairro.setColumns(10);
		bairro.setBounds(193, 176, 112, 20);
		add(bairro);
		
		JLabel lblNewLabel = new JLabel("Bairro:");
		lblNewLabel.setBounds(148, 179, 43, 14);
		add(lblNewLabel);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(161, 210, 32, 14);
		add(lblRua);
		
		rua = new JTextField();
		rua.setText(ruaBd);
		rua.setColumns(10);
		rua.setBounds(193, 207, 112, 20);
		add(rua);
		
		JLabel lblNewLabel_6 = new JLabel("CEP:");
		lblNewLabel_6.setBounds(160, 239, 33, 14);
		add(lblNewLabel_6);
		
		cep = new JTextField();
		cep.setText(cepBd);
		cep.setColumns(10);
		cep.setBounds(193, 236, 112, 20);
		add(cep);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(325, 128, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarFornecedores checar = new ChecarFornecedores();
				Menu.atualizarPainel(checar);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AlterarFornecedor.class.getResource("/Imagens/Voltar.png")));
		btnNewButton_1.setBounds(27, 235, 87, 23);
		add(btnNewButton_1);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 290);
		add(planoFundo);

	}
}
