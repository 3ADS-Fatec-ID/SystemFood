package model;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import services.BD;

public class AnotarPedido extends JPanel {
	private JTextField tfnomeCliente;
	private JTextField tfBairro;
	private JTextField tfRua;
	private JTextField tfComp;
	private static BD bd;
	public String[] lanches;
	private String nomeCliente, bairro, rua, complemento;
//	private String nomeBebida, nomeComida;
	private int qtdLanche, qtdBebida, idComida, idBebida;
	private Double precoLanche, precoBebida;
	
	/**
	 * Create the panel.
	 */
	public AnotarPedido() {
		Random newPedido = new Random();
		int codPedido = newPedido.nextInt(100);
		bd = new BD();
		bd.getConnection();
		setLayout(null);
		String[] lanches = new String[] {"", "", "", ""};
		String[] bebidas = new String[] {"", "", "", "", ""};
		
		int i = 0;
		String sql = "SELECT * FROM comidas;";
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execu��o
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
			 lanches[i] = Integer.toString(bd.rs.getInt("idComida"))+" "+bd.rs.getString("nomeComida")+" "+bd.rs.getString("preco");
			 i++;
			}
			i = 0; 
		} catch (SQLException erro) {
     	   System.out.println("ERRO => " + erro);
     	   JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }  catch ( NullPointerException erro ) {
				System.out.println("ERRO => " + erro.getCause().toString());
        }
		
		String sqlBebidas = "SELECT * FROM produtos WHERE tipoProduto = 2;";
		
		try {
			bd.st = bd.con.prepareStatement(sqlBebidas); //preparei a query para a execu��o
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				bebidas[i] = Integer.toString(bd.rs.getInt("idProduto"))+" "+bd.rs.getString("descricao")+" "+bd.rs.getString("valorVenda");
				i++;
			}
			
		} catch (SQLException erro) {
     	   System.out.println("ERRO => " + erro);
     	   JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }  catch ( NullPointerException erro ) {
				System.out.println("ERRO => " + erro.getCause().toString());
        }
		
		
//		String[] bebidas = new String[] {"Coca-Cola","Fanta Laranja","Fanta Uva","Sprite","Itubaina"};
		DefaultListModel<Object> model_list = new DefaultListModel<Object>();
	    DefaultListModel<Object> listLanchesAnot = new DefaultListModel<Object>();
	    DefaultListModel<Object> model_list_2 = new DefaultListModel<Object>();
	    DefaultListModel<Object> listBebidasAnot = new DefaultListModel<Object>();
	    ArrayList<String> pedidoLanches = new ArrayList();
		ArrayList<String> pedidoBebidas = new ArrayList();
	    for (String value : lanches) {
	        model_list.addElement(value);
	    }
	    for(String value : bebidas) {
	        model_list_2.addElement(value);
	        
	    }
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 76, 142, 155);
		add(scrollPane);
		JList<Object> list = new JList<Object>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		list.setModel(model_list);
		
		JButton btnAddComida = new JButton("+");
		btnAddComida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				boolean c= false;
				while(cont!=30) {
				if(listLanchesAnot.contains(Integer.toString(cont)+" "+list.getSelectedValue()))
				{
					c=true;
					break;
				}
				else {cont++;}
				}
				if(c==false) {
					list.getSelectedValuesList().stream().forEach((data) -> {
						int a=1;
						try {
						a = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade !"));
						qtdLanche = a;
						if(a<=0)
						{
							a=1;
						}
						String b= Integer.toString(a)+" "+data.toString();
//						System.out.println(idComida);
						
						pedidoLanches.add(Integer.toString(codPedido));
						pedidoLanches.add("null");
//						pedidoLanches.add(Integer.toString(idComida));
//						pedidoLanches.add(Integer.toString(a));
		                listLanchesAnot.addElement(b);
//	                listaComidas.addElementdata.toString();
//	                model_list.removeElement(data);
						}
						catch(NumberFormatException erro)
						{
							JOptionPane.showConfirmDialog(null, "Digite apenas n�meros !","Erro",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
						}
						
		                
		            });
				}
				
			}
		});
		btnAddComida.setBounds(181, 113, 46, 23);
		add(btnAddComida);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(237, 76, 142, 155);
		add(scrollPane_1);
		
		JList<Object> list_1 = new JList<Object>();
		scrollPane_1.setViewportView(list_1);
		list_1.setModel(listLanchesAnot);
		
		JButton removerL = new JButton("-");
		removerL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()!=-1) {
				listLanchesAnot.removeElementAt(list_1.getSelectedIndex());}
				else {}
			}
		});
		removerL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removerL.setBounds(181, 159, 46, 23);
		add(removerL);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(409, 76, 113, 155);
		add(scrollPane_2);
		
		JList<Object> list_2 = new JList<Object>();
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setModel(model_list_2);
		scrollPane_2.setViewportView(list_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(588, 76, 113, 155);
		add(scrollPane_3);
		
		JList<Object> list_3 = new JList<Object>();
		list_3.setModel(listBebidasAnot);
		scrollPane_3.setViewportView(list_3);
		
		JButton btnAddBebida = new JButton("+");
		btnAddBebida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				boolean c= false;
				while(cont!=30) {
				if(listBebidasAnot.contains(Integer.toString(cont)+" "+list_2.getSelectedValue()))
				{
					c=true;
					break;
				}
				else {cont++;}
				}
				if(c==false) {
				list_2.getSelectedValuesList().stream().forEach((data) -> {
					int a=1;
					try {
					a = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade !"));
					qtdBebida = a;
					if(a<=0)
					{
						a=1;
					}
					String b= Integer.toString(a)+" "+data.toString();
	                listBebidasAnot.addElement(b);
//	                model_list_3.removeElement(data);
					}
					catch(NumberFormatException erro)
					{
						JOptionPane.showConfirmDialog(null, "Digite apenas n�meros !","Erro",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					}
	                
	            });}
			}
			
		});
		btnAddBebida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBebida.setBounds(532, 113, 46, 23);
		add(btnAddBebida);
		
		JButton removerL_1 = new JButton("-");
		removerL_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_3.getSelectedIndex()!=-1) {
					listBebidasAnot.removeElementAt(list_3.getSelectedIndex());}
					else {}
			}
		});
		removerL_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removerL_1.setBounds(532, 159, 46, 23);
		add(removerL_1);
		
		JLabel lblNewLabel = new JLabel("Card\u00E1pio Lanches:");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblNewLabel.setBounds(48, 57, 102, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lanches Anotados:");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(255, 57, 119, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bebidas Anotadas:");
		lblNewLabel_1_1.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(592, 57, 113, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblCardpioBebidas = new JLabel("Card\u00E1pio Bebidas:");
		lblCardpioBebidas.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblCardpioBebidas.setBounds(416, 57, 102, 14);
		add(lblCardpioBebidas);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 729, 288);
		add(planoFundo);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setBounds(10, 17, 46, 14);
		add(lblNewLabel_2);
		
		tfnomeCliente = new JTextField();
		tfnomeCliente.setBounds(55, 14, 109, 20);
		add(tfnomeCliente);
		tfnomeCliente.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Presencial")
				{
					tfBairro.setEnabled(false);
					tfBairro.setText("");
					tfRua.setEnabled(false);
					tfRua.setText("");
					tfComp.setEnabled(false);
					tfComp.setText("");
				}
				else {tfBairro.setEnabled(true);
				      tfRua.setEnabled(true);
				      tfComp.setEnabled(true);}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Presencial", "Entrega"}));
		comboBox.setBounds(174, 14, 88, 20);
		add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(270, 17, 46, 14);
		add(lblNewLabel_3);
		
		tfBairro = new JTextField();
		tfBairro.setEnabled(false);
		tfBairro.setBounds(312, 14, 86, 20);
		add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Rua:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(409, 17, 46, 14);
		add(lblNewLabel_5);
		
		tfRua = new JTextField();
		tfRua.setEnabled(false);
		tfRua.setBounds(445, 14, 128, 20);
		add(tfRua);
		tfRua.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Complemento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(583, 17, 82, 14);
		add(lblNewLabel_4);
		
		tfComp = new JTextField();
		tfComp.setEnabled(false);
		tfComp.setBounds(660, 14, 59, 20);
		add(tfComp);
		tfComp.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd = new BD();
				bd.getConnection();
				nomeCliente = tfnomeCliente.getText();
				bairro = tfBairro.getText();
				rua = tfRua.getText();
				complemento = tfComp.getText();
				System.out.println(nomeCliente+", "+bairro+", "+rua+", "+complemento+"\n");
				
				String sqlTeste = "INSERT INTO pedidos (idPedido, nomeCliente, valorPedido, rua, bairro, complemento, taxaEntrega)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
				try {
					bd.st = bd.con.prepareStatement(sqlTeste); //preparei a query para a execu��o
					bd.st.setInt(1, codPedido);
					bd.st.setString(2, nomeCliente);
					bd.st.setDouble(3, 50.50);
					bd.st.setString(4, rua);
					bd.st.setString(5, bairro);
					bd.st.setString(6, complemento);
					bd.st.setDouble(7, 5.50);
					bd.st.executeUpdate();
				} catch( SQLException error ) {
					System.out.println("ERRO => " + error);
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				int n = listLanchesAnot.getSize();
                int i=0;
                for (i=0; i<n; i++) {
	                String item = (String) listLanchesAnot.getElementAt(i);
	                String [] Dados= item.split(" ");
//	                System.out.println(Dados[0]);
//	                System.out.println(Dados[1]);
//	                System.out.println(Dados[2]);
	                System.out.println(Dados[3]);
	                String sql = "INSERT INTO itensPedido (idPedido, idComida, quantidade) VALUES (?, ?, ?);";
	                try {
						bd.st = bd.con.prepareStatement(sql); //preparei a query para a execu��o
						bd.st.setInt(1, codPedido);
						bd.st.setInt(2, Integer.parseInt(Dados[1]));
						bd.st.setInt(3, Integer.parseInt(Dados[0]));
						bd.st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso");
					} catch( SQLException error ) {
						System.out.println("ERRO => " + error);
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
	             }
                for (i=0; i<n; i++) {
	                String item = (String) listBebidasAnot.getElementAt(i);
	                String [] Dados= item.split(" ");
//	                System.out.println(Dados[0]);
//	                System.out.println(Dados[1]);
//	                System.out.println(Dados[2]);
	                System.out.println(Dados[3]);
	                String sql = "INSERT INTO itensPedido (idPedido, idProduto, quantidade) VALUES (?, ?, ?);";
	                try {
						bd.st = bd.con.prepareStatement(sql); //preparei a query para a execu��o
						bd.st.setInt(1, codPedido);
						bd.st.setInt(2, Integer.parseInt(Dados[1]));
						bd.st.setInt(3, Integer.parseInt(Dados[0]));
						bd.st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso");
					} catch( SQLException error ) {
						System.out.println("ERRO => " + error);
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
	             }
                
                
                
                System.out.println(listLanchesAnot);
			}
		});
		btnSalvar.setBounds(601, 244, 88, 33);
		add(btnSalvar);
		
	}
}
