package model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import services.BD;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ChecarFornecedores extends JPanel {
	private JTable tbFornecedores;
	private DefaultTableModel model;
	public JButton alterar;
	public String idFornecedorStr;
	public int idFornecedor;
	public BD bd;
	/**
	 * Create the panel.
	 */
	public ChecarFornecedores() {
		setLayout(null);
		bd = new BD();
		bd.getConnection();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 362, 243);
		add(scrollPane);
		
//		Object[][] data = new Object[][] {{"101", "Ramesh"}, {"102", "Adithya"}, {"103", "Jai"}, {"104", "Sai"}};
//	     String[] columnNames = new String[] {"ID", "Nome","CNPJ","email","telefone","endereco"};
	    model = MyModel.getModel(Login.bd, "SELECT * FROM fornecedores;");
		tbFornecedores = new JTable(model);
		
		tbFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbFornecedores);
//		carregarTabela();
		tbFornecedores.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	idFornecedorStr = tbFornecedores.getValueAt(tbFornecedores.getSelectedRow(), 0).toString();
            	int userObj = Integer.parseInt(idFornecedorStr);
        		System.out.println("USEROBJ => "+idFornecedorStr);
        		idFornecedor = userObj;
        		bd.close();
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
		
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarFornecedor alteraF = new AlterarFornecedor(idFornecedor);
				Menu.atualizarPainel(alteraF);
			}
		});
		
		alterar.setBackground(new Color(255, 140, 0));
		alterar.setBounds(382, 46, 89, 23);
		add(alterar);
		
		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbFornecedores.getSelectedRow() != -1) {
		               // remove selected row from the model
//		               System.out.println(model.getValueAt(table.getSelectedRow(), 0));
		               model.removeRow(tbFornecedores.getSelectedRow());
		               
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
