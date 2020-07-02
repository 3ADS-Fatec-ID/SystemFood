package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlePedidos extends JPanel {
	private JTable tbPedidos;
	private DefaultTableModel model;
	public int idPedido;


	/**
	 * Create the panel.
	 */
	public ControlePedidos() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 11, 706, 166);
		add(scrollPane);
		
		model =  MyModel.getModel(Login.bd, "SELECT \r\n" + 
				"	t1.idPedido AS 'CÓDIGO',\r\n" + 
				"	t1.nomeCliente AS 'NOME',\r\n" + 
				"	t1.valorPedido AS 'VALOR',\r\n" + 
				"    t1.taxaEntrega AS 'TAXA DE ENTREGA'\r\n" + 
				"FROM pedidos AS t1\r\n" + 
				"LEFT JOIN itenspedido AS t2 ON t1.idPedido = t2.idPedido\r\n" + 
				"GROUP BY t1.idPedido;");
		tbPedidos = new JTable(model);

		scrollPane.setViewportView(tbPedidos);
		
		tbPedidos.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	String userObjStr = tbPedidos.getValueAt(tbPedidos.getSelectedRow(), 0).toString();
            	int userObj = Integer.parseInt(userObjStr);
        		System.out.println("USEROBJ => "+userObj);
        		idPedido = userObj;
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
		
		JButton botaoChecar = new JButton("");
		botaoChecar.setIcon(new ImageIcon(ControlePedidos.class.getResource("/Imagens/Lupa.png")));
		botaoChecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarPedido checar= new ChecarPedido(idPedido);
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
