package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Alternativa;


public class AlternativaDAOImpl extends DaoGenericoImp<Alternativa, Serializable> implements AlternativaDAO {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Override
	public Alternativa consultar(Integer codigo) {
		return super.pesquisarPorId(codigo);
	}

	@Override
	public void inserir(Alternativa alternativa) {
		super.salvar(alternativa);

	}

	@Override
	public boolean existe(Integer codigo) {
		Alternativa a = consultar(codigo);
		return (a != null);

	}

	@Override
	public List<Alternativa> listar() {
		return super.todos();
	}

}
