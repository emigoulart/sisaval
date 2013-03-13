package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Alternativa;
import edu.infnet.model.Questao;
import edu.infnet.model.Questaoalternativa;
import edu.infnet.model.QuestaoalternativaPK;

public interface QuestaoalternativaDAO {
	
	public abstract Questaoalternativa consultar(QuestaoalternativaPK codigo);

	public abstract void inserir(Questaoalternativa questaoalternativa);

	public abstract List<Questaoalternativa> listar();

	public abstract List<Questaoalternativa> alternativasQuestao(Questao questao);

	public abstract List<Questaoalternativa> questoesAlternativa(Alternativa alternativa);

}
