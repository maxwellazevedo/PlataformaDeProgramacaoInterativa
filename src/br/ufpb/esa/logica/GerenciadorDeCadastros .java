package br.ufpb.esa.logica;

import java.util.List;
import java.util.LinkedList;

public class GerenciadorDeCadastros {

	private List <Professor> professores = new LinkedList <Professor>();
	private List <Aluno> alunos = new LinkedList <Aluno>();
	
	public void cadastraProfessor(String nome, String login){
		Professor professor = new Professor (nome, login);
		professores.add(professor);
		
	}
	

	public Professor pesquisarProfessor (String matricula){
		for(Professor p: professores){
			if(p.getMatricula().equals(matricula)){
				return p;

	/**
	 * cadastra o Professor, caso este ja esteja cadastrado, lança uma exceção 
	 */
	public void cadastraProfessor(String nome, String matricula, Login login) throws ProfessorJaExisteException{ // inicializa um professor, adicionando-o no List
		boolean existe = false; // variavel booleana que muda caso o professor exista
		for(Professor p: professores){
			if(p.getNome().equals(nome) && p.getMatricula().equals(matricula)){
				existe = true;
				throw new ProfessorJaExisteException("Professor já existe!");

			}
		}
		return null;
	}

	
	public void apagarProfessor (String matricula, String login, String senha){
		for(Professor p : professores){
			if(p.getMatricula().equals(matricula)){
				if(p.getLogin().equalsIgnoreCase(login)){
					if(p.getSenha().equals(senha)){
						professores.remove(p);
					}
				}

	/**
	 * Pesquisar Professor passando o nome
	 */
	public List<Professor> pesquisaProfessorPeloNome(String nome){ 
		List <Professor> professoresEncontrados = new LinkedList<Professor>();
		for(Professor p: professores){
			if(p.getNome().indexOf(nome) != -1){
				professoresEncontrados.add(p);

			}
		}
	}
	

	public void atualizarProfessor (String matricula, String nome, String senha){
		Professor p = this.pesquisarProfessor(matricula);
		if(nome != null){
			p.setNome(nome);
		}
		if(senha != null){
			p.setSenha(senha);
		}
	}
	
	public void cadastrarAluno(String nome, String login){
		Aluno aluno = new Aluno ( nome, login);
		alunos.add(aluno);
	}
	
	public Aluno pesquisarAluno (String matricula){
		for(Aluno a: alunos){
			if(a.getMatricula().equals(matricula)){
				return a;
			}

	
	/**
	 * Pesquisar professor passando a matricula 
	 */
	public Professor pesquisaProfessorPelaMatricula(String matricula) throws ProfessorInexistenteException{
		boolean encontrouP = false;
		for(Professor p: professores){
			if(p.getMatricula().equals(matricula)){
				encontrouP = true;
				return p;
			}
		}if(!encontrouP){
			throw new ProfessorInexistenteException("Professor: Matrícula inválida ou inexistente!");
		}else{
			return null;

		}
		return null;
	}

	
	public void removerAluno (String matricula){
		Aluno aluno = this.pesquisarAluno(matricula);
		alunos.remove(aluno);
	}
	
	public void atualizarAluno (String matricula, String nome, String senha){
		Aluno a = this.pesquisarAluno(matricula);
		if(nome != null){
			a.setNome(nome);
		}
		if(senha != null){
			a.setSenha(senha);

	 /**
	 * remover Professor
	 */
	public void removeProfessor(String matricula)throws ProfessorInexistenteException {
		boolean removidoProf = false;
		for(Professor p: professores){
			if(p.getMatricula().equals(matricula)){
				professores.remove(p);
				removidoProf = true;
			}break;
		}if(removidoProf == false){
			throw new ProfessorInexistenteException("Professor inexistente!");

		}
	}
	
	 public void criarTurma (String matricula, String codigo, String periodo, String horario){
		 Professor p = this.pesquisarProfessor(matricula);
		 p.alocarTurma(codigo, periodo, horario);
	 }
	 
	 public Turma pesquisaTurma (String matricula, String codigo){
		 Professor p = this.pesquisarProfessor(matricula);
		 return p.pesquisaTurma(codigo);
	 }
	 
	 public void adicionarAlunoTurma (String matriculaAluno, String matriculaProfessor, String codigo){
		 Professor p = this.pesquisarProfessor(matriculaProfessor);
		 Turma t = p.pesquisaTurma(codigo);
		 Aluno a = this.pesquisarAluno(matriculaAluno);
		 t.alocarAluno(a);
	 }
}
