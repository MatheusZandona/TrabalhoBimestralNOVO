package br.univel.classes;

import java.sql.SQLException;

public class Principal {

	public Principal(){
		
		Cliente c1 = new Cliente();
		c1.setId(2);
		c1.setNome("Maria");
		c1.setEndereco("sadasdadsd");
		c1.setTelefone("(45) 9999-0000");
		c1.setEstadocivil(EstadoCivil.Solteiro);
		
		Cliente c2 = new Cliente();
		c2.setId(3);
		c2.setNome("Maria 3");
		c2.setEndereco("sadasdadsdddddddddddd");
		c2.setTelefone("(45) 9349-1100");
		c2.setEstadocivil(EstadoCivil.Casado);
		
		ConexaoBD conexao = new ConexaoBD();
		
		
		//instancia Dao
		DaoImpl d = new DaoImpl();
		
		//seta conexão
		try {
			d.setConexao(conexao.abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//chamar métodos
		System.out.println("apagarTabela\n");
		d.apagarTabela(c1);
		
		System.out.println("criarTabela\n");
		d.criarTabela(c1);
		
		System.out.println("inserir objeto 1\n");
		d.salvar(c1);
		
		System.out.println("inserir objeto 2\n");
		d.salvar(c2);
		
		
		System.out.println("listarTodos");
		for(Cliente c : d.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + 
							   c.getTelefone() + " - " + c.getEstadocivil().toString());			
		}
		
		
		System.out.println("\nbuscar objeto 1");
		Cliente c4 = new Cliente();
		c4 = d.buscar(c1.getId());		
		System.out.println(c4.getId() + " - " + c4.getNome() + " - " + c4.getEndereco() + " - " + 
						   c4.getTelefone() + " - " + c4.getEstadocivil().toString());			

		
		System.out.println("\nalterar objeto 2\n");
		c2.setEstadocivil(EstadoCivil.Casado);
		d.atualizar(c2);
		
	
		
		System.out.println("listarTodos");		
		for(Cliente c : d.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + 
							   c.getTelefone() + " - " + c.getEstadocivil().toString());			
		}
		
		
		//fecha a conexão
		d.setConexao(null);
		try {
			conexao.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		new Principal();
	}
}
