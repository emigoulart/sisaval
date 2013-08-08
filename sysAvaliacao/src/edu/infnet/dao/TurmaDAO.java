package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Turma;
import edu.infnet.model.TurmaAluno;
import edu.infnet.model.Usuario;

public interface TurmaDAO extends Serializable {
	
	public abstract Turma consultar(Integer codigo);

	public abstract Turma atualizar(Turma turma);

	public abstract void inserir(Turma turma);

	public abstract void excluir(Turma turma);

	public abstract void excluir(Integer codigo);

	public abstract boolean existe(Integer id);

	public abstract Turma consultarPorAluno(final Usuario aluno);

	public abstract List<Turma> listar();
	
	public abstract List<TurmaAluno> consultarAlunosTurma(Turma turma);
	

}
