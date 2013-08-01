package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import edu.infnet.model.Curso;

public class CursoDAOImpl extends DaoGenericoImp<Curso,Serializable> implements CursoDAO {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(CursoDAOImpl.class);
	
	@Override
	public Curso consultar(Integer codigo) {
		return null;
	}

	@Override
	public Curso atualizar(Curso curso) {
		log.info("Atualizando um registro - "+curso.getCurNome());	
		return super.atualizar(curso);
	}

	@Override
	public void inserir(Curso curso) {
		log.info("inserindo um registro - " + curso.getCurNome());
		super.salvar(curso);
	}

	@Override
	public void excluir(Curso curso) {
		log.info("Excluindo um registro - "+curso.getCurNome());
		super.excluir(curso);

	}

	@Override
	public Curso consultarPorNome(String nome) {
		return new Curso();
	}

	@Override
	public List<Curso> listar() {	
		return super.todos();
	}

}
