package br.ufpb.esa.logica;

abstract class Usuario {
	private String nome;
	private Login login;
	private String matricula;
	
	
	public Usuario (String nome, String matricula, Login login){
		this.nome = nome;
		this.matricula = matricula;
		this.login = login;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
