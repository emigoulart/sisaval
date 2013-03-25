package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Questao;

public class QuestaoDAOImpl  extends DaoGenericoImp<Questao, Serializable> implements QuestaoDAO {

	@Override
	public Questao consultar(Integer codigo) {
		return super.pesquisarPorId(codigo);
	}

	@Override
	public void inserir(Questao questao) {
		super.salvar(questao);
	}

	@Override
	public boolean existe(Integer codigo) {
		Questao q = consultar(codigo);
		return (q != null);
	}

	@Override
	public List<Questao> listar() {
		return super.todos();
	}

}
