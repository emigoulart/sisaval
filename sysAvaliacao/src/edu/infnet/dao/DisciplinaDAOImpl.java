package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import edu.infnet.model.Disciplina;

public class DisciplinaDAOImpl extends DaoGenericoImp<Disciplina,Serializable> implements DisciplinaDAO {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(DisciplinaDAOImpl.class);
			
	@Override
	public Disciplina consultar(Integer codigo) {
		return null;
	}

	@Override
	public Disciplina atualizar(Disciplina disiciplina) {
		return super.atualizar(disiciplina);
	}

	@Override
	public void inserir(Disciplina disiciplina) {
		super.salvar(disiciplina);
	}

	@Override
	public void excluir(Disciplina disiciplina) {
		super.excluir(disiciplina);

	}

	@Override
	public Disciplina consultarPorNome(String nome) {
		return new Disciplina();
	}

	@Override
	public List<Disciplina> listar() {	
		return super.todos();
	}

}	