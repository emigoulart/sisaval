package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Disciplina;
import edu.infnet.model.Usuario;

public interface DisciplinaDAO extends Serializable {
	
	public abstract Disciplina consultar(Integer codigo);

    public abstract Disciplina atualizar(Disciplina disciplina);

	public abstract void inserir(Disciplina disciplina);

	public abstract void excluir(Disciplina disciplina);

	public abstract Disciplina consultarPorNome(String nome);

	public abstract List<Disciplina> listar();

	public abstract List<Disciplina> listarDisciplinasPorAluno(Usuario aluno);

}
