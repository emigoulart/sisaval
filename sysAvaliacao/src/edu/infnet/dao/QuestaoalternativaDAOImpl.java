package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Alternativa;
import edu.infnet.model.Questao;
import edu.infnet.model.Questaoalternativa;
import edu.infnet.model.QuestaoalternativaPK;

public class QuestaoalternativaDAOImpl extends DaoGenericoImp<Questaoalternativa, Serializable> implements QuestaoalternativaDAO {

	@Override
	public Questaoalternativa consultar(QuestaoalternativaPK codigo) {
		return super.pesquisarPorId(codigo);
		
	}

	@Override
	public void inserir(Questaoalternativa questaoalternativa) {
		super.salvar(questaoalternativa);

	}

	@Override
	public List<Questaoalternativa> listar() {
		return super.todos();
	}

	@Override
	public List<Questaoalternativa> alternativasQuestao(Questao questao) {
		return null;
	}

	@Override
	public List<Questaoalternativa> questoesAlternativa(Alternativa alternativa) {
		// TODO Auto-generated method stub
		return null;
	}

}
