package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Curso;

public interface CursoDAO extends Serializable {
	
	
    public abstract Curso consultar(Integer codigo);

    public abstract Curso atualizar(Curso curso);

	public abstract void inserir(Curso curso);

	public abstract void excluir(Curso curso);

	public abstract Curso consultarPorNome(String nome);

	public abstract List<Curso> listar();
}
