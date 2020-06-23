package Pi;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ChecarFornecedores extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	public JButton alterar;
	/**
	 * Create the panel.
	 */
	public ChecarFornecedores() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 362, 243);
		add(scrollPane);
		
		Object[][] data = new Object[][] {{"101", "Ramesh"}, {"102", "Adithya"}, {"103", "Jai"}, {"104", "Sai"}};
	     String[] columnNames = new String[] {"ID", "Nome","CNPJ","email","telefone","endereco"};
	      model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
//		carregarTabela();
		
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarFornecedor alteraF = new AlterarFornecedor();
				Menu.atualizarPainel(alteraF);
			}
		});
		
		alterar.setBackground(new Color(255, 140, 0));
		alterar.setBounds(382, 46, 89, 23);
		add(alterar);
		
		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
		               // remove selected row from the model
//		               System.out.println(model.getValueAt(table.getSelectedRow(), 0));
		               model.removeRow(table.getSelectedRow());
		               
				}
			}
		});
		excluir.setForeground(new Color(0, 0, 0));
		excluir.setBackground(new Color(178, 34, 34));
		excluir.setBounds(382, 90, 89, 23);
		add(excluir);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 290);
		add(planoFundo);
		
		
		
	}
	public void carregarTabela()
		{
//			model= MyModel.getModel(Menu.bd, "select* from fornecedor");
//			table.setModel(model);
			
		}
}
