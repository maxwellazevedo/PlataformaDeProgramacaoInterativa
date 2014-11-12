
package br.ufpb.esa.logica;

public class Usuario {
	
	protected String nome;
	protected String matricula;
	protected String login;
	protected String senha;
	
	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
