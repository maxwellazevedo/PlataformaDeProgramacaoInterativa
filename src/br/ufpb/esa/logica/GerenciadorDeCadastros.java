package br.ufpb.esa.logica;

import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeCadastros {
	private List<Professor> professores;
	private List<Aluno> alunos;
	private List<Turma> turma;
	
	
	public GerenciadorDeCadastros(){
		this.professores = new LinkedList <Professor>();
		this.alunos = new LinkedList <Aluno>();
		this.turma = new LinkedList<Turma>();
	}
	
	
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
		}if(!existe){
			Professor prof = new Professor(nome, matricula, login);
			this.professores.add(prof);
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
		return professoresEncontrados;
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
	}
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
}
