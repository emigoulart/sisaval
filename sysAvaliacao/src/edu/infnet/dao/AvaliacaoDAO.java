package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Avaliacao;
import edu.infnet.model.Turma;
import edu.infnet.model.Usuario;

public interface AvaliacaoDAO {

	public abstract Avaliacao consultar(Integer codigo);

	//public abstract void atualizar(Avaliacao avaliacao);

	public abstract boolean incluirAvaliacao(Avaliacao avaliacao);

	public abstract List<Avaliacao> consultarAvaliacoesAluno(Usuario aluno);

	public abstract List<Avaliacao> consultarAvaliacoesTurma(Turma turma);

	//public abstract List<Disciplina> consultarDisciplinasAluno(Usuario aluno);

	public abstract boolean existe(Integer id);

	public abstract List<Avaliacao> listar();

}
