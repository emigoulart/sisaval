package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Turma;
import edu.infnet.model.TurmaAluno;

public interface TurmaDAO {
	
	public abstract Turma consultar(Integer codigo);

	public abstract void atualizar(Turma turma);

	public abstract void inserir(Turma turma);

	public abstract void excluir(Turma turma);

	public abstract void excluir(Integer codigo);

	public abstract boolean existe(Integer id);

	//public abstract Turma consultarPorAluno(Session session, A nome);

	public abstract List<Turma> listar();
	
	public abstract List<TurmaAluno> consultarAlunosTurma(Turma turma);
	

}
