package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.BD;

public class AlterarProduto extends JPanel {
	private JTextField descricao;
	private JTextField valorC;
	private JTextField valorV;
	private JTextField quantidade;
	private JTextField estoqueM;
	private String descricaobd, valorVenda, valorCompra, tipoProdStr;
	private int quant, tipoProd, estoqueMin, idFornecedor, idProduto;
	private BD bd;

	/**
	 * Create the panel.
	 */
	public AlterarProduto(int idProduto) {
		
		bd = new BD();
		bd.getConnection();
		String sql = "SELECT * FROM produtos WHERE idProduto = " + idProduto;
		
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			descricaobd =  bd.rs.getString("descricao");
			valorVenda = bd.rs.getString("valorVenda");
			valorCompra =  bd.rs.getString("valorCompra");
			quant =  bd.rs.getInt("quantidade");
			tipoProd = bd.rs.getInt("tipoProduto");
			estoqueMin = bd.rs.getInt("estoqueMinimo");
			idFornecedor = bd.rs.getInt("idFornecedor");
			bd.close();
		} catch( SQLException error ) {
			System.out.println("ERRO => " + error);
		}
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setBounds(354, 30, 69, 14);
		add(lblNewLabel);
		
		descricao = new JTextField();
		descricao.setText(descricaobd);
		descricao.setColumns(10);
		descricao.setBounds(426, 27, 130, 20);
		add(descricao);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Compra:");
		lblNewLabel_1.setBounds(169, 71, 83, 14);
		add(lblNewLabel_1);
		
		valorC = new JTextField();
		valorC.setText(valorCompra);
		valorC.setColumns(10);
		valorC.setBounds(261, 68, 86, 20);
		add(valorC);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Venda:");
		lblNewLabel_2.setBounds(357, 71, 76, 14);
		add(lblNewLabel_2);
		
		valorV = new JTextField();
		valorV.setText(valorVenda);
		valorV.setEditable(false);
		valorV.setColumns(10);
		valorV.setBounds(441, 68, 86, 20);
		add(valorV);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setBounds(169, 113, 69, 14);
		add(lblNewLabel_3);
		
		quantidade = new JTextField();
		quantidade.setText(Integer.toString(quant));
		quantidade.setColumns(10);
		quantidade.setBounds(249, 110, 86, 20);
		add(quantidade);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Produto:");
		lblNewLabel_4.setBounds(169, 31, 76, 14);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		if(tipoProd == 1) {
			System.out.println("Comida");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Comida", "Bebida"}));
			comboBox.setBounds(255, 27, 86, 20);
			add(comboBox);
		} else if(tipoProd == 2) {
			System.out.println("Bebida");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebida", "Comida"}));
			comboBox.setBounds(255, 27, 86, 20);
			add(comboBox);
		}
		
		JLabel lblNewLabel_3_1 = new JLabel("Estoque Minimo:");
		lblNewLabel_3_1.setBounds(351, 113, 93, 14);
		add(lblNewLabel_3_1);
		
		estoqueM = new JTextField();
		estoqueM.setText(Integer.toString(estoqueMin));
		estoqueM.setColumns(10);
		estoqueM.setBounds(456, 110, 86, 20);
		add(estoqueM);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(AlterarProduto.class.getResource("/Imagens/Calcular.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float a = Float.parseFloat(valorC.getText());
					DecimalFormat b = new DecimalFormat("0.00");
					double c= a*0.20+a;
					valorV.setText(b.format(c));
					}
					catch(NumberFormatException erro)
					{
						JOptionPane.showConfirmDialog(null, "Digite apenas números !","Erro",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
						valorC.setText("");
					}
			}
		});
		btnNewButton_1.setBounds(534, 68, 39, 20);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Fornecedor:");
		lblNewLabel_5.setBounds(271, 154, 69, 14);
		add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		if(idFornecedor == 1) {
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Fábrica dos pães", "Alimentos S.A.", "Bebidas S.A."}));
			comboBox_1.setBounds(342, 150, 122, 22);
			add(comboBox_1);
		} else if(idFornecedor == 2) {
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Alimentos S.A.","Fábrica dos pães", "Bebidas S.A."}));
			comboBox_1.setBounds(342, 150, 122, 22);
			add(comboBox_1);
		} else if(idFornecedor == 3) {
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bebidas S.A.", "Fábrica dos pães", "Alimentos S.A.", }));
			comboBox_1.setBounds(342, 150, 122, 22);
			add(comboBox_1);
		}
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarEstoque checar= new ChecarEstoque();
				Menu.atualizarPainel(checar);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AlterarProduto.class.getResource("/Imagens/Voltar.png")));
		btnNewButton_2.setBounds(71, 227, 87, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 728, 288);
		add(lblNewLabel_6);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				bd = new BD();
//				bd.getConnection();
				int idProd = idProduto;
				descricaobd = descricao.getText();
				valorVenda = valorV.getText();
				valorCompra = valorC.getText();
				if(comboBox.getSelectedItem().equals("comida")) {
					tipoProd = 1;
					tipoProdStr = "comida";
				} else {
					tipoProd = 2;
					tipoProdStr = "bebida";
				}
				quant = Integer.parseInt(quantidade.getText());
				estoqueMin = Integer.parseInt(estoqueM.getText());
				if(comboBox_1.getSelectedItem().equals("Fábrica dos pães")) {
					idFornecedor = 1;
				} else if(comboBox_1.getSelectedItem().equals("Alimentos S.A.")) {
					idFornecedor = 2;
				} else if(comboBox_1.getSelectedItem().equals("Bebidas S.A.")) {
					idFornecedor = 3;
				}
				
				String sqlTest = "UPDATE produtos SET descricao = '"+descricaobd+"', valorVenda = '"+valorVenda+"', valorCompra = '"+valorCompra+"',"
						+ " tipoProduto = '"+tipoProd+"', tipoProdutoStr = '"+tipoProdStr+"', quantidade = '"+quant+"',"
						+ " estoqueMinimo = '"+estoqueMin+"', idFornecedor = '"+idFornecedor+"'"
						+ " WHERE idProduto = '"+idProd+"';";
				System.out.println(sqlTest);
				
				String sql = "UPDATE produtos SET descricao = ?, valorVenda = ?, valorCompra = ?, tipoProduto = ?"
						+ ", tipoProdutoStr = ?, quantidade = ?, estoqueMinimo = ?, idFornecedor = ? "
						+ " WHERE idProduto = ?";
				
				
				System.out.println(sql);
				bd = new BD();
				bd.getConnection();
				try {
				
					bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
					bd.st.setString(1, descricaobd);
					bd.st.setString(2, valorVenda);
					bd.st.setString(3, valorCompra);
					bd.st.setInt(4, tipoProd);
					bd.st.setString(5, tipoProdStr);
					bd.st.setInt(6, quant);
					bd.st.setInt(7,  estoqueMin);
					bd.st.setInt(8, idFornecedor);
					bd.st.setInt(9, idProduto);
					System.out.println(sql);
					bd.st.executeUpdate();
					descricao.setText("");
					valorV.setText("");
					valorC.setText("");
					quantidade.setText("");
					estoqueM.setText("");
					JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
				} catch( SQLException error ) {
					System.out.println("ERRO => " + error);
					JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSalvar.setBounds(316, 195, 92, 23);
		add(btnSalvar);

	}
}
