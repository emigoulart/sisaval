package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Turma;
import edu.infnet.model.TurmaAluno;

public class TurmaDAOImpl extends DaoGenericoImp<Turma, Serializable> implements TurmaDAO{

	private static final long serialVersionUID = 1L;

	@Override
	public Turma consultar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Turma atualizar(Turma turma){
		return super.atualizar(turma);
	}
	@Override
	public void inserir(Turma turma) {
		super.salvar(turma);
		
	}

	@Override
	public void excluir(Turma turma) {
		super.excluir(turma);
		
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Turma> listar() {
		return super.todos();
	}

	@Override
	public List<TurmaAluno> consultarAlunosTurma(Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Integer codigo) {
		// TODO Auto-generated method stub
		
	}

	
	
}
