package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import services.BD;


public class ChecarPedido extends JPanel {
	private static BD bd;
	public String nomeClient, enderecoClient;

	/**
	 * Create the panel.
	 */
	public ChecarPedido(int idPedido) {
		setLayout(null);
		bd = new BD();
		bd.getConnection();
		String[] lanches = new String[] {"", "", "", ""};
		String[] bebidas = new String[] {"", "", "", "", ""};
		
		String sql = "SELECT  nomeCliente, CONCAT(rua,', ', bairro)  AS 'endereco'  FROM pedidos WHERE idPedido = " + idPedido;
		
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			nomeClient =  bd.rs.getString("nomeCliente");
			enderecoClient = bd.rs.getString("endereco");
		} catch( SQLException error ) {
			System.out.println("ERRO => " + error);
		}
		
		int i = 0;
		String sqlLanches = "SELECT \r\n" + 
				"	t1.quantidade,\r\n" + 
				"	t2.nomeComida\r\n" + 
				"FROM itenspedido AS t1\r\n" + 
				"LEFT JOIN comidas AS t2 ON t1.idComida = t2.idComida\r\n" + 
				"WHERE t1.idPedido = 1 AND t2.idComida IS NOT NULL;"; 
		try {
			bd.st = bd.con.prepareStatement(sqlLanches); //preparei a query para a execu��o
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				lanches[i] = Integer.toString(bd.rs.getInt("quantidade"))+" "+bd.rs.getString("nomeComida");
				i++;
			}
			i = 0; 
		} catch (SQLException erro1) {
     	   System.out.println("ERRO => " + erro1);
     	   JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }  catch ( NullPointerException erro ) {
        	System.out.println("ERRO => " + erro.getCause().toString());
        }	
		
		String sqlBebidas = "SELECT \r\n" + 
				"	t1.quantidade,\r\n" + 
				"    t2.descricao\r\n" + 
				"FROM itenspedido AS t1\r\n" + 
				"LEFT JOIN produtos AS t2 ON t1.idProduto = t2.idProduto\r\n" + 
				"WHERE t1.idPedido = 1 AND t2.descricao IS NOT NULL;"; 
		try {
			bd.st = bd.con.prepareStatement(sqlBebidas); //preparei a query para a execu��o
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				bebidas[i] = Integer.toString(bd.rs.getInt("quantidade"))+" "+bd.rs.getString("descricao");
				i++;
			}
			i = 0; 
		} catch (SQLException erro1) {
     	   System.out.println("ERRO => " + erro1);
     	   JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }  catch ( NullPointerException erro ) {
        	System.out.println("ERRO => " + erro.getCause().toString());
        }	
		
		DefaultListModel<Object> model_list = new DefaultListModel<Object>();
		DefaultListModel<Object> model_list1 = new DefaultListModel<Object>();
		for (String value : lanches) {
	        model_list.addElement(value);
	    }
	    for(String value : bebidas) {
	        model_list1.addElement(value);
	        
	    }
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 49, 202, 177);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Comidas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 51, 56, 14);
		add(lblNewLabel);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		list.setModel(model_list);
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(375, 49, 202, 177);
		add(scrollPane_1);
		
		JLabel lblBebidas = new JLabel("Bebidas:");
		lblBebidas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBebidas.setBounds(319, 51, 56, 14);
		add(lblBebidas);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setModel(model_list1);
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		add(lblNewLabel_1);
		
		JLabel nome = new JLabel("");
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nome.setForeground(new Color(0, 0, 255));
		nome.setBounds(54, 11, 162, 14);
		nome.setText(nomeClient);
		add(nome);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Total:");
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(507, 264, 115, 14);
		add(lblNewLabel_2);
		
		JLabel valorTotal = new JLabel("");
		valorTotal.setFont(new Font("Stencil", Font.PLAIN, 16));
		valorTotal.setBounds(619, 264, 87, 14);
		valorTotal.setText("R$ 75.00");
		add(valorTotal);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlePedidos controle= new ControlePedidos();
				Menu.atualizarPainel(controle);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ChecarPedido.class.getResource("/Imagens/Voltar.png")));
		btnNewButton.setBounds(36, 255, 87, 23);
		add(btnNewButton);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 729, 289);
		add(planoFundo);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(203, 11, 62, 14);
		add(lblNewLabel_3);
		
		JLabel enderecoCliente = new JLabel("R. Jurandir de Faria, 03 - Jardim do Sol");
		enderecoCliente.setForeground(Color.BLUE);
		enderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		enderecoCliente.setBounds(263, 11, 456, 14);
		enderecoCliente.setText(enderecoClient);
		add(enderecoCliente);
		
		JButton btnNewButton_1 = new JButton("Alterar Pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPedido alteracao = new AlterarPedido(idPedido);
				Menu.atualizarPainel(alteracao);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setBounds(587, 81, 132, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finalizar Pedido");
		btnNewButton_2.setBackground(new Color(178, 34, 34));
		btnNewButton_2.setBounds(587, 130, 132, 23);
		add(btnNewButton_2);
		System.out.println(list.getModel().getSize());

	}
}
