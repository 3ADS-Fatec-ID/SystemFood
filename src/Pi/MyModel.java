package Pi;

	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Types;
	import java.text.DecimalFormat;
	import java.util.Vector;

	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;

	public class MyModel{
		private static DefaultTableModel tableModel;

		public static DefaultTableModel getModel(BD bd, String sql) {
			try {
				Vector<String> cabecalho = new Vector<String>();
				Vector<Vector<String>> linhas = new Vector<Vector<String>>();
				bd.instrucaoParametrizada = bd.conexao.prepareStatement(sql);
				bd.manipularConsulta = bd.instrucaoParametrizada.executeQuery();
				bd.manipularConsulta.next();
				// busca os cabecalhos 
				ResultSetMetaData rsmd = bd.manipularConsulta.getMetaData();
				for ( int i = 1; i <= rsmd.getColumnCount(); i++ ) 
					cabecalho.addElement( rsmd.getColumnName( i ) );
		
				// busca dados das linhas
				do {
					Vector<String> linhaAtual = new Vector<String>();
					DecimalFormat df = new DecimalFormat("R$ 00.00");
					for ( int i = 1; i <= rsmd.getColumnCount(); i++ ){
						switch( rsmd.getColumnType(i)) {
						case Types.VARCHAR:
							linhaAtual.addElement(bd.manipularConsulta.getString(i));break;
						case Types.CHAR:
							linhaAtual.addElement(bd.manipularConsulta.getString(i));break;
						case Types.TIMESTAMP:
							linhaAtual.addElement(""+bd.manipularConsulta.getDate(i));break;
						case Types.DOUBLE:
							linhaAtual.addElement(""+bd.manipularConsulta.getDouble(i));break;
						case Types.INTEGER:
							linhaAtual.addElement(""+bd.manipularConsulta.getInt(i));break;
						case Types.NUMERIC:
							linhaAtual.addElement(""+df.format(bd.manipularConsulta.getDouble(i)));break;
						case Types.SMALLINT:
							linhaAtual.addElement(""+bd.manipularConsulta.getInt(i));break;
						case Types.DECIMAL:
							linhaAtual.addElement(""+bd.manipularConsulta.getDouble(i));break;
		//					default:System.out.println(rsmd.getColumnType(i));   
						}
					}
					linhas.addElement(linhaAtual);     
				} 
				while (bd.manipularConsulta.next());       

				tableModel = new DefaultTableModel(linhas,cabecalho);
			}
			catch (SQLException erro) { 
				return new DefaultTableModel();
			}
			return tableModel;
		}
	}




