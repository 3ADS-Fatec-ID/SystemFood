package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import services.BD;

public class ChecarUsuarios extends JPanel {
	private JTable tbUsuarios;
	private DefaultTableModel model;
	public int idUsuario;
	public static BD bd;

	/**
	 * Create the panel.
	 */
	public ChecarUsuarios() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 28, 292, 243);
		add(scrollPane);
		
	    model = MyModel.getModel(Login.bd, "SELECT * FROM usuarios");
	    
		tbUsuarios = new JTable(model);
		tbUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbUsuarios.getColumnModel().getColumn(1).setPreferredWidth(300);
		
		
		
		scrollPane.setViewportView(tbUsuarios);
		
		tbUsuarios.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	String userObjStr = tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 0).toString();
            	int userObj = Integer.parseInt(userObjStr);
        		System.out.println("USEROBJ => "+userObj);
        		idUsuario = userObj;
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
				UsuarioDAO alteraU = new UsuarioDAO(idUsuario);
				Menu.atualizarPainel(alteraU);
			}
		});
		alterar.setBackground(new Color(255, 140, 0));
		alterar.setBounds(356, 50, 89, 23);
		add(alterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbUsuarios.getSelectedRow() != -1) {
		               // remove selected row from the model
//		               System.out.println(model.getValueAt(table.getSelectedRow(), 0));
		               
					String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
		               try {
		            	   String userStr = Integer.toString(idUsuario);
			               System.out.println(sql);
		            	   bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
		            	   bd.st.setString(1, userStr);
			               int teste = bd.st.executeUpdate();
			               System.out.println(teste);
			               JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
		               } catch (SQLException erro) {
		            	   System.out.println("ERRO => " + erro);
		            	   JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
		               }  catch ( NullPointerException erro ) {
							System.out.println("ERRO => " + erro);
		               }
		               model.removeRow(tbUsuarios.getSelectedRow());
		               
				}
			}
		});
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setBackground(new Color(178, 34, 34));
		btnExcluir.setBounds(356, 94, 89, 23);
		add(btnExcluir);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);

	}
}
