package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.BD;

public class CadastroProduto extends JPanel {
	private JTextField descricao;
	private JTextField valorC;
	private JTextField valorV;
	private JTextField quantidade;
	private JTextField estoqueM;
	public BD bd;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		setLayout(null);

		JLabel lblTipoProd = new JLabel("Tipo Produto:");
		lblTipoProd.setBounds(36, 29, 76, 14);
		add(lblTipoProd);

		JComboBox cbtipoProd = new JComboBox();
		cbtipoProd.setModel(new DefaultComboBoxModel(new String[] { "Bebida", "Comida" }));
		cbtipoProd.setBounds(122, 25, 86, 20);
		add(cbtipoProd);

		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setBounds(221, 28, 69, 14);
		add(lblNewLabel);

		descricao = new JTextField();
		descricao.setBounds(293, 25, 130, 20);
		add(descricao);
		descricao.setColumns(10);

		JLabel lblValorC = new JLabel("Valor Compra:");
		lblValorC.setBounds(36, 69, 83, 14);
		add(lblValorC);

		valorC = new JTextField();
		valorC.setBounds(128, 66, 86, 20);
		add(valorC);
		valorC.setColumns(10);

		JLabel lblValorv = new JLabel("Valor Venda:");
		lblValorv.setBounds(224, 69, 76, 14);
		add(lblValorv);

		valorV = new JTextField();
		valorV.setEditable(false);
		valorV.setBounds(308, 66, 86, 20);
		add(valorV);
		valorV.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(36, 111, 69, 14);
		add(lblQuantidade);

		quantidade = new JTextField();
		quantidade.setBounds(116, 108, 86, 20);
		add(quantidade);
		quantidade.setColumns(10);

		JLabel lblEstoqueM = new JLabel("Estoque Minimo:");
		lblEstoqueM.setBounds(218, 111, 93, 14);
		add(lblEstoqueM);

		estoqueM = new JTextField();
		estoqueM.setColumns(10);
		estoqueM.setBounds(323, 108, 86, 20);
		add(estoqueM);

		JLabel lblNewLabel_5 = new JLabel("Fornecedor:");
		lblNewLabel_5.setBounds(138, 152, 69, 14);
		add(lblNewLabel_5);

		JComboBox cbFornecedor = new JComboBox();
		cbFornecedor.setModel(
				new DefaultComboBoxModel(new String[] { "Fábrica dos pães", "Alimentos S.A.", "Bebidas S.A." }));
		cbFornecedor.setBounds(209, 148, 122, 22);
		add(cbFornecedor);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(188, 193, 92, 23);
		add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bd = new BD();
				bd.getConnection();
				String sql = "INSERT INTO produtos (descricao, valorVenda, valorCompra, tipoProduto, tipoProdutoStr, quantidade, idFornecedor, estoqueMinimo)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

				System.out.println(sql);

				try {

					bd.st = bd.con.prepareStatement(sql); // preparei a query para a execução
					bd.st.setString(1, descricao.getText());
					bd.st.setString(2, valorV.getText());
					bd.st.setString(3, valorC.getText());
					if (cbtipoProd.getSelectedItem().equals("comida")) {
						bd.st.setInt(4, 1);
					} else {
						bd.st.setInt(4, 2);
					}
					bd.st.setString(5, (String) cbtipoProd.getSelectedItem());
					bd.st.setString(6, quantidade.getText());
					bd.st.setString(8, estoqueM.getText());
					if (cbFornecedor.getSelectedItem().equals("Fábrica dos pães")) {
						bd.st.setInt(7, 1);
					} else if (cbFornecedor.getSelectedItem().equals("Alimentos S.A.")) {
						bd.st.setInt(7, 2);
					} else if (cbFornecedor.getSelectedItem().equals("Bebidas S.A.")) {
						bd.st.setInt(7, 3);
					}
					System.out.println(sql);
					bd.st.executeUpdate();
					descricao.setText("");
					valorV.setText("");
					valorC.setText("");
					quantidade.setText("");
					estoqueM.setText("");

				} catch (SQLException error) {
					System.out.println("ERRO => " + error);
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\nInsira dados validos!", "ERRO",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton calcVenda = new JButton("");
		calcVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float a = Float.parseFloat(valorC.getText());
					DecimalFormat b = new DecimalFormat("0.00");
					double c = a * 0.20 + a;
					valorV.setText(b.format(c));
				} catch (NumberFormatException erro) {
					JOptionPane.showConfirmDialog(null, "Digite apenas números !", "Erro", JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
					valorC.setText("");
				}

			}
		});
		calcVenda.setIcon(new ImageIcon(CadastroProduto.class.getResource("/Imagens/Calcular.png")));
		calcVenda.setBounds(401, 66, 39, 20);
		add(calcVenda);

		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 289);
		add(planoFundo);

	}
}
