package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Alternativa;

public interface AlternativaDAO {

	public abstract Alternativa consultar(Integer codigo);

	public abstract void inserir(Alternativa alternativa);

	public abstract boolean existe(Integer codigo);

	public abstract List<Alternativa> listar();


	
}
