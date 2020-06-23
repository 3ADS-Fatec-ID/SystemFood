package Pi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class AlterarUsuario extends JPanel {

	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the Panel.
	 */
	public AlterarUsuario() {
		setBounds(100, 100, 481, 289);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(225, 42, 106, 20);
		add(textField);
		
		JLabel lblNewLabel = new JLabel("Nome do Usu\u00E1rio:");
		lblNewLabel.setBounds(109, 45, 108, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha do Usu\u00E1rio:");
		lblNewLabel_1.setBounds(109, 82, 116, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 79, 106, 20);
		add(textField_1);
		
		JButton btnNewButton = new JButton("Salvar Altera\u00E7\u00F5es");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(206, 143, 145, 23);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usu\u00E1rio"}));
		comboBox.setBounds(225, 116, 106, 20);
		add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Permiss\u00E3o de Acesso:");
		lblNewLabel_1_1.setBounds(84, 119, 129, 14);
		add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarUsuarios checar = new ChecarUsuarios();
				Menu.atualizarPainel(checar);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AlterarUsuario.class.getResource("/Imagens/Voltar.png")));
		btnNewButton_1.setBounds(57, 214, 87, 23);
		add(btnNewButton_1);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);
	}
}
