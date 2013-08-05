package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Avaliacao;
import edu.infnet.model.Disciplina;
import edu.infnet.model.Turma;
import edu.infnet.model.Usuario;

public interface AvaliacaoDAO extends Serializable{

	public abstract Avaliacao consultar(final Integer codigo);

	//public abstract void atualizar(Avaliacao avaliacao);

	public abstract boolean incluirAvaliacao(final Avaliacao avaliacao);

	public abstract List<Avaliacao> consultarAvaliacoesAluno(final Usuario aluno);

	public abstract List<Avaliacao> consultarAvaliacoesTurma(final Turma turma);
	
	public abstract Avaliacao consultarAvaliacoesDisciplinaAluno(final Usuario aluno, final Disciplina disciplina);

	public abstract boolean existe(final Integer id);

	public abstract List<Avaliacao> listar();

	

}
