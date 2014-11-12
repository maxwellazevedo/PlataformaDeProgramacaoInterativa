package br.ufpb.esa.logica;

import java.util.LinkedList;
import java.util.List;




public class Professor extends Usuario {

	private List <Turma> turmas;
	
	public Professor(String nome, String login) {
		
		
		turmas = new LinkedList <Turma>();
	}
	
	public void alocarTurma (String codigo, String periodo, String horario){
		Turma turma = new Turma (codigo, periodo, horario, this);
		turmas.add(turma);
	}
	
	public List<Turma> listaTurmas (){
		return turmas;
	}
	
	public Turma pesquisaTurma(String codigo){
		for(Turma t : turmas){
			if(t.getCodigo().equals(codigo)){
				return t;
			}
		}
		return null;
	}
	
}
