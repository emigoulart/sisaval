package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import edu.infnet.model.Questao;

public class QuestaoDAOImpl  extends DaoGenericoImp<Questao, Serializable> implements QuestaoDAO {

private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(CursoDAOImpl.class);

	@Override
	public Questao consultar(Integer codigo) {
		return super.pesquisarPorId(codigo);
	}

	@Override
	public void inserir(Questao questao) {
		super.salvar(questao);
	}

	@Override
	public Questao atualizar(Questao questao) {
		log.info("Atualizando um registro - " + questao.getQstQuestao());
		return super.atualizar(questao);
	}

	@Override
	public void excluir(Questao questao) {
		log.info("Excluindo um registro - " + questao.getQstQuestao());
		super.excluir(questao);

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
