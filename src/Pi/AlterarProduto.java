package Pi;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AlterarProduto extends JPanel {
	private JTextField descricao;
	private JTextField valorC;
	private JTextField valorV;
	private JTextField quantidade;
	private JTextField estoqueM;

	/**
	 * Create the panel.
	 */
	public AlterarProduto() {
		setLayout(null);
		
		descricao = new JTextField();
		descricao.setColumns(10);
		descricao.setBounds(426, 27, 130, 20);
		add(descricao);
		
		valorC = new JTextField();
		valorC.setColumns(10);
		valorC.setBounds(261, 68, 86, 20);
		add(valorC);
		
		valorV = new JTextField();
		valorV.setEditable(false);
		valorV.setColumns(10);
		valorV.setBounds(441, 68, 86, 20);
		add(valorV);
		
		quantidade = new JTextField();
		quantidade.setColumns(10);
		quantidade.setBounds(249, 110, 86, 20);
		add(quantidade);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setBounds(354, 30, 69, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Compra:");
		lblNewLabel_1.setBounds(169, 71, 83, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Venda:");
		lblNewLabel_2.setBounds(357, 71, 76, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setBounds(169, 113, 69, 14);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebida", "Ingrediente"}));
		comboBox.setBounds(255, 27, 86, 20);
		add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Produto:");
		lblNewLabel_4.setBounds(169, 31, 76, 14);
		add(lblNewLabel_4);
		
		estoqueM = new JTextField();
		estoqueM.setColumns(10);
		estoqueM.setBounds(456, 110, 86, 20);
		add(estoqueM);
		
		JLabel lblNewLabel_3_1 = new JLabel("Estoque Minimo:");
		lblNewLabel_3_1.setBounds(351, 113, 93, 14);
		add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(316, 195, 92, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(AlterarProduto.class.getResource("/Imagens/Calcular.png")));
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
		btnNewButton_1.setBounds(534, 68, 39, 20);
		add(btnNewButton_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(342, 150, 122, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Fornecedor:");
		lblNewLabel_5.setBounds(271, 154, 69, 14);
		add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarEstoque checar= new ChecarEstoque();
				Menu.atualizarPainel(checar);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AlterarProduto.class.getResource("/Imagens/Voltar.png")));
		btnNewButton_2.setBounds(71, 227, 87, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 728, 288);
		add(lblNewLabel_6);

	}
}
