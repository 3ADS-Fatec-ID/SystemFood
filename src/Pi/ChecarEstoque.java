package Pi;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class ChecarEstoque extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public ChecarEstoque() {
		setLayout(null);
		setBounds(100, 100, 729, 288);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 711, 216);
		add(scrollPane);
		
		Object[][] data = new Object[][] {{"","","","","","","",""}, {"","","","","","","",""}, {"","","","","","","",""}, {"","","","","","","",""}};
	     String[] columnNames = new String[] {"ID","descricao","idFornecedor","ValorCompra","ValorVenda","tipoProduto","quantidade","estoqueMinimo"};
	      model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
		               // remove selected row from the model
//		               System.out.println(model.getValueAt(table.getSelectedRow(), 0));
		               model.removeRow(table.getSelectedRow());
		               }
			}
		});
		btnNewButton.setBounds(479, 238, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarProduto alterarP= new AlterarProduto();
				Menu.atualizarPainel(alterarP);
			}
		});
		btnNewButton_1.setBounds(162, 238, 89, 23);
		add(btnNewButton_1);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 728, 288);
		add(planoFundo);

	}
}
