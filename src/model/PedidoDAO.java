package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.BD;

public class PedidoDAO {
	
	private BD bd;
	public String sql;
	
	public PedidoDAO() {
		bd = new BD();
	}
	
	public String selectComidas() {
		
		String sql = "SELECT * FROM comidas;";
		try {
			bd.st = bd.con.prepareStatement(sql); //preparei a query para a execução
			bd.rs = bd.st.executeQuery();
			
			
		} catch (SQLException erro) {
     	   System.out.println("ERRO => " + erro);
     	   JOptionPane.showMessageDialog(null, "Erro ao alterar.\nInsira dados validos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }  catch ( NullPointerException erro ) {
				System.out.println("ERRO => " + erro.getCause().toString());
        }
		return "Comidas";
	}
}
