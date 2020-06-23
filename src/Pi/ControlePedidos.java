package Pi;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ControlePedidos extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ControlePedidos() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 11, 706, 166);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "nomeCliente", "endereco", "valorPedido", "taxaEntrega"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(3).setPreferredWidth(68);
		scrollPane.setViewportView(table);
		
		JButton botaoChecar = new JButton("");
		botaoChecar.setIcon(new ImageIcon(ControlePedidos.class.getResource("/Imagens/Lupa.png")));
		botaoChecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarPedido checar= new ChecarPedido();
				Menu.atualizarPainel(checar);
			}
		});
		botaoChecar.setBounds(324, 188, 88, 76);
		add(botaoChecar);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 290);
		add(planoFundo);

	}
}
