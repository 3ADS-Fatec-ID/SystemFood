package Pi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField usuario_senha;
	private JButton botao_login;
	public static boolean admin;
	private JLabel planoFundo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Login() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Tela de login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(65, 37, 52, 14);
		contentPane.add(lblNewLabel);
		
		usuario = new JTextField();
		usuario.setBounds(118, 34, 86, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(73, 62, 43, 14);
		contentPane.add(lblNewLabel_1);
		
		usuario_senha = new JPasswordField();
		usuario_senha.setBounds(118, 58, 86, 20);
		contentPane.add(usuario_senha);
		
		botao_login = new JButton("Login");
		botao_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String c = usuario.getText();
				if(c.equals("Admin"))
					{
						admin=true;
					}
					else if(c.equals("User"))
					{
						admin=false;
					}
					
					Login.this.setVisible(false);
					Menu m = new Menu();
					m.setVisible(true);
					
					
					
			}
		});
		botao_login.setBounds(118, 105, 86, 23);
		botao_login.setForeground(Color.BLUE);
		botao_login.setBackground(Color.LIGHT_GRAY);
		contentPane.add(botao_login);
		
		planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 320, 162);
		contentPane.add(planoFundo);
	}

	

}
