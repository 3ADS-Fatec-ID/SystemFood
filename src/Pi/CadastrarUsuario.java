package Pi;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastrarUsuario extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CadastrarUsuario() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(226, 66, 106, 20);
		add(textField);
		
		JLabel lblNewLabel = new JLabel("Nome do Usu\u00E1rio:");
		lblNewLabel.setBounds(110, 69, 108, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha do Usu\u00E1rio:");
		lblNewLabel_1.setBounds(110, 106, 116, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(226, 103, 106, 20);
		add(textField_1);
		
		JButton btnNewButton = new JButton("Salvar Cadastro");
		btnNewButton.setBounds(207, 167, 145, 23);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usu\u00E1rio"}));
		comboBox.setBounds(226, 140, 106, 20);
		add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Permiss\u00E3o de Acesso:");
		lblNewLabel_1_1.setBounds(85, 143, 129, 14);
		add(lblNewLabel_1_1);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);
		
		
	}
}
