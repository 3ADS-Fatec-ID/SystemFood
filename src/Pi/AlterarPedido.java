package Pi;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class AlterarPedido extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AlterarPedido() {
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
		scrollPane.setBounds(29, 73, 142, 155);
		add(scrollPane);
		
		JList<Object> list = new JList<Object>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		list.setModel(model_list);
		
		JButton adicionarL = new JButton("+");
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
		adicionarL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adicionarL.setBounds(181, 110, 46, 23);
		add(adicionarL);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(237, 73, 142, 155);
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
		removerL.setBounds(181, 156, 46, 23);
		add(removerL);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(409, 73, 113, 155);
		add(scrollPane_2);
		
		JList<Object> list_2 = new JList<Object>();
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setModel(model_list_2);
		scrollPane_2.setViewportView(list_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(588, 73, 113, 155);
		add(scrollPane_3);
		
		JList<Object> list_3 = new JList<Object>();
		scrollPane_3.setViewportView(list_3);
		list_3.setModel(model_list_3);
		
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
		adicionarL_1.setBounds(532, 110, 46, 23);
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
		removerL_1.setBounds(532, 156, 46, 23);
		add(removerL_1);
		
		JLabel lblNewLabel = new JLabel("Card\u00E1pio Lanches:");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblNewLabel.setBounds(48, 54, 102, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lanches Anotados:");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(255, 54, 119, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bebidas Anotadas:");
		lblNewLabel_1_1.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(592, 54, 113, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblCardpioBebidas = new JLabel("Card\u00E1pio Bebidas:");
		lblCardpioBebidas.setFont(new Font("Dubai Medium", Font.PLAIN, 13));
		lblCardpioBebidas.setBounds(416, 54, 102, 14);
		add(lblCardpioBebidas);
		
		JButton btnNewButton = new JButton("Salvar Altera\u00E7\u00F5es");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(588, 241, 113, 33);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(55, 11, 109, 20);
		add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setBounds(10, 14, 46, 14);
		add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Presencial", "Entrega"}));
		comboBox.setBounds(174, 11, 88, 20);
		add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(327, 11, 260, 20);
		add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(270, 14, 58, 14);
		add(lblNewLabel_3);
		
		JButton voltar = new JButton("");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarPedido checar = new ChecarPedido();
				Menu.atualizarPainel(checar);
			}
		});
		voltar.setIcon(new ImageIcon(AlterarPedido.class.getResource("/Imagens/Voltar.png")));
		voltar.setBounds(40, 246, 87, 23);
		add(voltar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 729, 288);
		add(lblNewLabel_4);

	}
}
