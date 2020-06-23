package Pi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	public Connection con = null;
	public Statement st = null;
	public PreparedStatement instrucaoParametrizada = null;
	public CallableStatement instrucaoArmazenada = null;
	public ResultSet rs = null;
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String BANCO = "systemfood";
	private final String URL = "jdbc:mysql://localhost:3306/" + BANCO;
//	private final String URL = "jdbc:mysql://localhost:3306/" + BANCO + "/integratedSecurity=true";
	private final String LOGIN = "root";
	private final String SENHA = "mysql@root1234";
	
	/**
	 * Realiza a conexão com o banco de dados
	 * @return - true(SUCESSO) ou false(ERRO)
	 */
	public boolean getConnection() {
		try {
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
//			con = DriverManager.getConnection(URL);
			System.out.println("Conectado!");
		} catch(SQLException erro) {
			
			System.out.println("Falha na conexão ao banco!" + erro.toString());
		} catch (ClassNotFoundException erro) {
			
			System.out.println("Driver não encontrado!");
		}
		return true;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) {
				con.close();
				System.out.println("Desconectado!");
			}
		} catch (SQLException e) {
			
		}
	}
}
