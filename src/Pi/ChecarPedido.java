package Pi;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


public class ChecarPedido extends JPanel {

	/**
	 * Create the panel.
	 */
	public ChecarPedido() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 49, 202, 177);
		add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"2 X-Tudo  R$ 20.00", "3 Cachorro Quente  R$ 9.00"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Comidas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 51, 56, 14);
		add(lblNewLabel);
		
		JLabel lblBebidas = new JLabel("Bebidas:");
		lblBebidas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBebidas.setBounds(319, 51, 56, 14);
		add(lblBebidas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(375, 49, 202, 177);
		add(scrollPane_1);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"1 Coca-Cola  R$ 3.00", "2 Fanta Uva  R$ 2.50"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		add(lblNewLabel_1);
		
		JLabel nomeCliente = new JLabel("");
		nomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomeCliente.setForeground(new Color(0, 0, 255));
		nomeCliente.setBounds(54, 11, 162, 14);
		nomeCliente.setText("Rochele Dias Pereira");
		add(nomeCliente);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("R. Jurandir de Faria, 03 - Jardim do Sol");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(263, 11, 456, 14);
		add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Alterar Pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPedido alteracao = new AlterarPedido();
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
