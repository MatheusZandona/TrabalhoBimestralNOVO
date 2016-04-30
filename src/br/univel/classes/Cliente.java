package br.univel.classes;

import br.unive.anotacoes.Coluna;
import br.unive.anotacoes.Tabela;

// acessar para estudar projeto Lucas Medeiros https://github.com/LucasMedeiros10/Trabalho1BimJava

@Tabela("Cliente")
public class Cliente {
	
	@Coluna(nome="ID",pk=true)
	private int id;
	
	@Coluna(nome="CLINOME")
	private String nome;
	
	@Coluna(nome="CLIENDERECO")
	private String endereco;
	
	@Coluna(nome="CLITELEFONE")
	private String telefone;
	
	@Coluna(nome="CLIESTADOCIVIL")
	private EstadoCivil estadocivil;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}
	
	
}
