package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	public Connection conectarBD() {
		/* 4 */ Connection conn = null;
		/* 5 */ try {

			/* 6 */
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/test?user=meu_usuario&password=minha_senha";

			/* 7 */
			conn = DriverManager.getConnection(url);

			/* 8 */} 
		/* 9 */catch (Exception e) {
			
		} /* 10 */
		
		/* 11 */ return conn;
	} 

	/* 1 */
	public String nome = "";
	public boolean result = false;

	public boolean verificarUsuario(String login, String senha) {
		/* 2 */ String sql = "";
		/* 3 */ Connection conn = conectarBD();

		// INSTRUÇÃO SQL

		/* 12 */
		sql += "select nome from usuarios ";
		sql += "where login = '" + login + "'";
		sql += " and senha = '" + senha + "';";

		/* 13 */ try {
			
			/* 14 */
			Statement st = conn.createStatement();
			
			/* 15 */
			ResultSet rs = st.executeQuery(sql);
			
			/* 16 */ if (rs.next()) {

				/* 17 */
				result = true;
				
				/* 18 */
				nome = rs.getString("nome");

			} /* 19 */
			
			/* 20 */ } 
		
		/* 21 */ catch (Exception e) {
			
		} /* 22 */
		
		/* 23 */ return result;
	} 
}
