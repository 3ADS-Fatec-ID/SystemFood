package model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class ChecarEstoque extends JPanel {
	private JTable tbProdutos;
	private DefaultTableModel model;
	public int idProduto;
	/**
	 * Create the panel.
	 */
	public ChecarEstoque() {
		setLayout(null);
		setBounds(100, 100, 729, 288);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 711, 216);
		add(scrollPane);
		
		//Object[][] data = new Object[][] {{"","","","","","","",""}, {"","","","","","","",""}, {"","","","","","","",""}, {"","","","","","","",""}};
	    //String[] columnNames = new String[] {"ID","descricao","idFornecedor","ValorCompra","ValorVenda","tipoProduto","quantidade","estoqueMinimo"};
	    model = MyModel.getModel(Login.bd, "SELECT * FROM produtos");
		tbProdutos = new JTable(model);
		scrollPane.setViewportView(tbProdutos);
		
		tbProdutos.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	String userObjStr = tbProdutos.getValueAt(tbProdutos.getSelectedRow(), 0).toString();
            	int userObj = Integer.parseInt(userObjStr);
        		System.out.println("USEROBJ => "+userObj);
        		idProduto = userObj;
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
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbProdutos.getSelectedRow() != -1) {
		               // remove selected row from the model
//		               System.out.println(model.getValueAt(table.getSelectedRow(), 0));
		               model.removeRow(tbProdutos.getSelectedRow());
		               }
			}
		});
		btnNewButton.setBounds(479, 238, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarProduto alterarP= new AlterarProduto(idProduto);
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
