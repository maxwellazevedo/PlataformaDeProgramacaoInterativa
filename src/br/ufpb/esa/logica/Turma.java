package br.ufpb.esa.logica;
import java.util.List;


public class Turma {
	
	private String codigo;
	private String periodo;
	private String horario;
	private Professor professor;
	private List <Aluno> alunosAlocados;

	public Turma (String codigo, String periodo, String horario, Professor professor){
		this.codigo = codigo;
		this.periodo = periodo;
		this.horario = horario;
		this.professor = professor;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public String getHorario() {
		return horario;
	}

	public Professor getProfessor() {
		return professor;
	}

	public List<Aluno> getAlunosAlocados() {
		return alunosAlocados;
	}
	
	public void alocarAluno (Aluno aluno){
		alunosAlocados.add(aluno);
	}
	
	public void removerAluno (Aluno aluno){
		alunosAlocados.remove(aluno);
	}
}
