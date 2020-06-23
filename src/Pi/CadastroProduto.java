package Pi;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class CadastroProduto extends JPanel {
	private JTextField descricao;
	private JTextField valorC;
	private JTextField valorV;
	private JTextField quantidade;
	private JTextField estoqueM;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		setLayout(null);
		
		descricao = new JTextField();
		descricao.setBounds(293, 25, 130, 20);
		add(descricao);
		descricao.setColumns(10);
		
		valorC = new JTextField();
		valorC.setBounds(128, 66, 86, 20);
		add(valorC);
		valorC.setColumns(10);
		
		valorV = new JTextField();
		valorV.setEditable(false);
		valorV.setBounds(308, 66, 86, 20);
		add(valorV);
		valorV.setColumns(10);
		
		quantidade = new JTextField();
		quantidade.setBounds(116, 108, 86, 20);
		add(quantidade);
		quantidade.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setBounds(221, 28, 69, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Compra:");
		lblNewLabel_1.setBounds(36, 69, 83, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Venda:");
		lblNewLabel_2.setBounds(224, 69, 76, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setBounds(36, 111, 69, 14);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebida", "Ingrediente"}));
		comboBox.setBounds(122, 25, 86, 20);
		add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Produto:");
		lblNewLabel_4.setBounds(36, 29, 76, 14);
		add(lblNewLabel_4);
		
		estoqueM = new JTextField();
		estoqueM.setColumns(10);
		estoqueM.setBounds(323, 108, 86, 20);
		add(estoqueM);
		
		JLabel lblNewLabel_3_1 = new JLabel("Estoque Minimo:");
		lblNewLabel_3_1.setBounds(218, 111, 93, 14);
		add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(188, 193, 92, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				float a = Float.parseFloat(valorC.getText());
				DecimalFormat b = new DecimalFormat("0.00");
				double c= a*0.20+a;
				valorV.setText(b.format(c));
				}
				catch(NumberFormatException erro)
				{
					JOptionPane.showConfirmDialog(null, "Digite apenas números !","Erro",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					valorC.setText("");
				}
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(CadastroProduto.class.getResource("/Imagens/Calcular.png")));
		btnNewButton_1.setBounds(401, 66, 39, 20);
		add(btnNewButton_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(209, 148, 122, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Fornecedor:");
		lblNewLabel_5.setBounds(138, 152, 69, 14);
		add(lblNewLabel_5);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);

	}
}
