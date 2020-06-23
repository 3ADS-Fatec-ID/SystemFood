package Pi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.Size;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private static JPanel contentPane;
	private boolean adm= true;
	public static BD bd;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Menu frame = new Menu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		bd = new BD();
//		bd.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 351);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu admin = new JMenu("Administrador");
		if(Login.admin==true)
		{
			admin.setVisible(true);
		}
		else {admin.setVisible(false);}
		menuBar.add(admin);
		
		JMenuItem cadastroUsuario = new JMenuItem("Cadastrar Usu\u00E1rio");
		cadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario cadastroU= new CadastrarUsuario();
				atualizarPainel(cadastroU);
				Menu.this.setSize(497, 351);

			}
		});
		admin.add(cadastroUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Controle Usu\u00E1rios");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarUsuarios checar= new ChecarUsuarios();
				atualizarPainel(checar);
				Menu.this.setSize(497, 351);

			}
		});
		admin.add(mntmNewMenuItem);

		JMenu pedido = new JMenu("Pedido");
		menuBar.add(pedido);
		
		JMenuItem anotarPedido = new JMenuItem("Anotar Pedido");
		anotarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnotarPedido anotar = new AnotarPedido();
				atualizarPainel(anotar);
				Menu.this.setSize(745,350);

			}
		});
		pedido.add(anotarPedido);
		
		JMenuItem controlePedidos = new JMenuItem("Controlar Pedidos");
		controlePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlePedidos controle = new ControlePedidos();
				atualizarPainel(controle);
				Menu.this.setSize(745,350);

			}
		});
		pedido.add(controlePedidos);
		
		JMenu estoque = new JMenu("Estoque");
		menuBar.add(estoque);
		
		JMenuItem cadastroProduto = new JMenuItem("Cadastrar novo produto");
		cadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto cadastroP = new CadastroProduto();
				atualizarPainel(cadastroP);
				Menu.this.setSize(497, 351);

			}
		});
		estoque.add(cadastroProduto);
		
		JMenuItem checarEstoque = new JMenuItem("Checar Estoque");
		checarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarEstoque checar= new ChecarEstoque();
				atualizarPainel(checar);
				Menu.this.setSize(745,350);
			}
		});
		estoque.add(checarEstoque);
		
		JMenu fornecedores = new JMenu("Fornecedores");
		menuBar.add(fornecedores);
		
		JMenuItem cadastroFornecedor = new JMenuItem("Cadastrar");
		cadastroFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFornecedor cadastro = new CadastroFornecedor();
				atualizarPainel(cadastro);
				Menu.this.setSize(497, 351);

			}
		});
		fornecedores.add(cadastroFornecedor);
		
		JMenuItem checarFornecedores = new JMenuItem("Checar Fornecedores");
		checarFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarFornecedores checar = new ChecarFornecedores();
				atualizarPainel(checar);
				Menu.this.setSize(497, 351);
			}
		});
		fornecedores.add(checarFornecedores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel planoFundo = new JLabel("");
		contentPane.add(planoFundo, BorderLayout.CENTER);
	}
	public static void atualizarPainel(JPanel a)
	{
		contentPane.removeAll();
		contentPane.add(a);
		contentPane.updateUI();
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

}
