package Pi;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ChecarUsuarios extends JPanel {
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ChecarUsuarios() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 28, 292, 243);
		add(scrollPane);
		
		Object[][] data = new Object[][] {{"1", "Amanda Costa","Administrador"}, {"2", "Carlos Andrade","Usuário"}, {"3", "Felipe Rodrigues","Usuário"}, {"4", "Sonia Souza","Usuário"}};
	     String[] columnNames = new String[] {"ID", "Nome","Permissão"};
	      model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarUsuario alteraU = new AlterarUsuario();
				Menu.atualizarPainel(alteraU);
			}
		});
		alterar.setBackground(new Color(255, 140, 0));
		alterar.setBounds(356, 50, 89, 23);
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
		excluir.setForeground(Color.BLACK);
		excluir.setBackground(new Color(178, 34, 34));
		excluir.setBounds(356, 94, 89, 23);
		add(excluir);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);

	}
}
