package br.univel.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.interfaces.Dao;
import classesAbstratas.SqlGen;

public class DaoImpl implements Dao<Cliente, Integer>{

	private Connection con = null;
	
	public Connection getConexao(){
		return con;
	}
	
	public void setConexao(Connection con1){
		this.con = con1;
	}
	
	@Override
	public void salvar(Cliente c) {
		SqlGenImpl gerador = new SqlGenImpl();
		
		try {
			PreparedStatement ps = gerador.getSqlInsert(con, c);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getTelefone());
			ps.setInt(5, c.getEstadocivil().ordinal());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente buscar(Integer k) {
		SqlGenImpl gerador = new SqlGenImpl();
		Cliente c = new Cliente();
				
		try {

			PreparedStatement ps = gerador.getSqlSelectById(con, new Cliente());
			ps.setInt(1, k);
			ResultSet resultados = ps.executeQuery();
			
			while (resultados.next()) {
				c.setId(resultados.getInt("id"));
				c.setNome(resultados.getString("clinome"));
				c.setEndereco(resultados.getString("cliendereco"));
				c.setTelefone(resultados.getString("clitelefone"));
				c.setEstadocivil(EstadoCivil.getPorid(resultados.getInt("cliestadocivil")));
			}			
			
			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return c;
	}

	@Override
	public void atualizar(Cliente t) {
		SqlGenImpl gerador = new SqlGenImpl();
		
		try {

			PreparedStatement ps = gerador.getSqlUpdateById(con, t);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getEndereco());
			ps.setString(3, t.getTelefone());
			ps.setInt(4, t.getEstadocivil().ordinal());
			ps.setInt(5, t.getId());
			
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}	
	}

	@Override
	public void excluir(Integer k) {
		SqlGenImpl gerador = new SqlGenImpl();
		
		try {

			PreparedStatement ps = gerador.getSqlDeleteById(con, new Cliente());
			ps.setInt(1, k);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

	@Override
	public List<Cliente> listarTodos() {
		SqlGenImpl gerador = new SqlGenImpl();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {

			PreparedStatement ps = gerador.getSqlSelectAll(con, new Cliente());
			ResultSet resultados = ps.executeQuery();
			
			while (resultados.next()) {
				
				Cliente cli = new Cliente();
				cli.setId(resultados.getInt("id"));
				cli.setNome(resultados.getString("clinome"));
				cli.setEndereco(resultados.getString("cliendereco"));
				cli.setTelefone(resultados.getString("clitelefone"));
				cli.setEstadocivil(EstadoCivil.getPorid(resultados.getInt("cliestadocivil")));
				
				listaClientes.add(cli);
			}			
			
			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return listaClientes;
	}
	
	public void criarTabela(Cliente t){
		SqlGenImpl gerador = new SqlGenImpl();
		
		try {
			String sql = gerador.getCreateTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			
		
	}
	
	public void apagarTabela(Cliente t){
		SqlGenImpl gerador = new SqlGenImpl();
				
		try {
			String sql = gerador.getDropTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			
		
	}	

}
