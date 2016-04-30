package br.univel.classes;

import java.sql.SQLException;

public class Principal {

	public Principal(){
		
		Cliente c1 = new Cliente();
		c1.setId(2);
		c1.setNome("Matheus");
		c1.setEndereco("R: Bento Gonçalves 736");
		c1.setTelefone("(45) 9961-9609");
		c1.setEstadocivil(EstadoCivil.Casado);
		
		Cliente c2 = new Cliente();
		c2.setId(3);
		c2.setNome("Mônica Rafaelli Chehban Zandoná");
		c2.setEndereco("R: Bento Gonçalves 736");
		c2.setTelefone("(45) 9912-6133");
		c2.setEstadocivil(EstadoCivil.Solteiro);
		
		ConexaoBD conexao = new ConexaoBD();
		
		
		DaoImpl d = new DaoImpl();
		
		try {
			d.setConexao(conexao.abrirConexao());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Apagar a Tabela\n");
		d.apagarTabela(c1);
		
		System.out.println("Criando a Tabela\n");
		d.criarTabela(c1);
		
		System.out.println("Inserindo Cliente 1\n");
		d.salvar(c1);
		
		System.out.println("Inserindo Cliente 2\n");
		d.salvar(c2);
		
		
		System.out.println("Mostrar Todos");
		for(Cliente c : d.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + 
							   c.getTelefone() + " - " + c.getEstadocivil().toString());			
		}
		
		
		System.out.println("\nbuscar cliente 1");
		Cliente c4 = new Cliente();
		c4 = d.buscar(c1.getId());		
		System.out.println(c4.getId() + " - " + c4.getNome() + " - " + c4.getEndereco() + " - " + 
						   c4.getTelefone() + " - " + c4.getEstadocivil().toString());			

		
		System.out.println("\nalterar cliente 2\n");
		c2.setEstadocivil(EstadoCivil.Casado);
		d.atualizar(c2);
		
	
		
		System.out.println("Mostrar Todos");		
		for(Cliente c : d.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + 
							   c.getTelefone() + " - " + c.getEstadocivil().toString());			
		}
		
		
		d.setConexao(null);
		try {
			conexao.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		new Principal();
	}
}
