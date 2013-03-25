package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Questao;

public interface QuestaoDAO {
	public abstract Questao consultar(Integer codigo);

	public abstract void inserir(Questao questao);

	public abstract boolean existe(Integer codigo);

	public abstract List<Questao> listar();


}
