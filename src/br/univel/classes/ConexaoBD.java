package br.univel.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	private Connection con = null;
	
	public Connection abrirConexao() throws SQLException {

		String url = "jdbc:h2:~/BDTrabalho";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);
		
		return con;
		
	}
	
	public void fecharConexao() throws SQLException{
		con.close();
	}
	
}
