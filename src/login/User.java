package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** 
 * Classe responsável pela autenticação de usuários.
 * 
 * <p>Essa classe fornece métodos para conexão com o banco de dados e login de usuários.</p>
 *
 * @author pedroh225
 * @version 1.0
 * 
 */
public class User {
	
	/**
	 * Realiza a conexão com o banco de dados.
	 * 
	 * @value conn Instância da conexão com o banco de dados.
	 * @value url A url do banco de dados passando o usuário e senha.
	 * 
	 * @return conn A instância da conexão com o banco de dados.
	 * 
	 * @throws SQLException Caso haja um erro na conexão com o banco.
	 */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/test?user=root&password=password";
            conn = DriverManager.getConnection(url);
            
        } catch (Exception e) { }
        return conn;
    }

    public String nome = "";
    public boolean result = false;
    
    
    /**
	 * Faz a autenticação do usuário.
	 * 
	 * @param login O login do usuário a ser autenticado.
	 * @param senha A senha do usuário a ser autenticado.
	 * 
	 * @value conn Instância da conexão com o banco de dados.
	 * @value sql String da consulta do banco de dados.
	 * @value st Reponsável por criar a consulta do banco.
	 * @value rs Responsável por armazenar o resultado da consulta do banco.
	 * @value result Responsável por atribuir o estado da autenticação do usuário
	 * @value nome Atributo da classe User, responsável por armazenar a string da coluna "nome" do banco de dados.
	 * 
	 * @return result True caso o usuário for autenticado com sucesso, caso contrário, retorna False.
	 * 
	 * @throws SQLException Caso haja um erro com a consulta ao banco de dados.
	 */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) { }
        return result;
    }
}
