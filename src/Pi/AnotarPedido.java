package Pi;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AnotarPedido extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Create the panel.
	 */
	public AnotarPedido() {
		setLayout(null);
		String[] lanches = new String[] {"X-Tudo","X-Calabresa","X-Salada","Misto Quente","Cachorro Quente"};
		String[] bebidas = new String[] {"Coca-Cola","Fanta Laranja","Fanta Uva","Sprite","Itubaina"};
		DefaultListModel<Object> model_list = new DefaultListModel<Object>();
	    DefaultListModel<Object> model_list_1 = new DefaultListModel<Object>();
	    DefaultListModel<Object> model_list_2 = new DefaultListModel<Object>();
	    DefaultListModel<Object> model_list_3 = new DefaultListModel<Object>();
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
		
		JButton adicionarL = new JButton("+");
		adicionarL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adicionarL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				boolean c= false;
				while(cont!=30) {
				if(model_list_1.contains(Integer.toString(cont)+" "+list.getSelectedValue()))
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
					if(a<=0)
					{
						a=1;
					}
					String b= Integer.toString(a)+" "+data.toString();
	                model_list_1.addElement(b);
//	                model_list.removeElement(data);
					}
					catch(NumberFormatException erro)
					{
						JOptionPane.showConfirmDialog(null, "Digite apenas números !","Erro",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					}
					
	                
	            });}
				
			}
		});
		adicionarL.setBounds(181, 113, 46, 23);
		add(adicionarL);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(237, 76, 142, 155);
		add(scrollPane_1);
		
		JList<Object> list_1 = new JList<Object>();
		scrollPane_1.setViewportView(list_1);
		list_1.setModel(model_list_1);
		
		JButton removerL = new JButton("-");
		removerL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()!=-1) {
				model_list_1.removeElementAt(list_1.getSelectedIndex());}
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
		list_3.setModel(model_list_3);
		scrollPane_3.setViewportView(list_3);
		
		JButton adicionarL_1 = new JButton("+");
		adicionarL_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				boolean c= false;
				while(cont!=30) {
				if(model_list_3.contains(Integer.toString(cont)+" "+list_2.getSelectedValue()))
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
					if(a<=0)
					{
						a=1;
					}
					String b= Integer.toString(a)+" "+data.toString();
	                model_list_3.addElement(b);
//	                model_list_3.removeElement(data);
					}
					catch(NumberFormatException erro)
					{
						JOptionPane.showConfirmDialog(null, "Digite apenas números !","Erro",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					}
	                
	            });}
			}
			
		});
		adicionarL_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adicionarL_1.setBounds(532, 113, 46, 23);
		add(adicionarL_1);
		
		JButton removerL_1 = new JButton("-");
		removerL_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_3.getSelectedIndex()!=-1) {
					model_list_3.removeElementAt(list_3.getSelectedIndex());}
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
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(601, 244, 88, 33);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(55, 14, 109, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setBounds(10, 17, 46, 14);
		add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Presencial")
				{
					textField_1.setEnabled(false);
					textField_1.setText("");
					textField_2.setEnabled(false);
					textField_2.setText("");
					textField_3.setEnabled(false);
					textField_3.setText("");
				}
				else {textField_1.setEnabled(true);
				      textField_2.setEnabled(true);
				      textField_3.setEnabled(true);}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Presencial", "Entrega"}));
		comboBox.setBounds(174, 14, 88, 20);
		add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(312, 14, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(445, 14, 128, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(660, 14, 59, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(270, 17, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Complemento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(583, 17, 82, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rua:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(409, 17, 46, 14);
		add(lblNewLabel_5);
		
		
		

	}
}
