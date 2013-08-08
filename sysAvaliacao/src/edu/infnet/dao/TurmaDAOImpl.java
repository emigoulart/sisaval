package edu.infnet.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.infnet.model.Turma;
import edu.infnet.model.TurmaAluno;
import edu.infnet.model.Usuario;

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

	@Override
	public Turma consultarPorAluno(Usuario aluno) {
		Turma turma= new Turma();
		
		String sqlQuery = " select t from Turma t left join t.turmaalunos as ta where fk_aluno = :aluno" ;
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aluno", aluno.getMatricula());
	
		 if(!super.listPesqParam(sqlQuery, parameters).isEmpty()){
			 turma= super.listPesqParam(sqlQuery, parameters).get(0);
		 }
		 return turma;
	}

	
	
}
