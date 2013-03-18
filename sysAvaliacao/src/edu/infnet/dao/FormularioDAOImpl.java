package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import edu.infnet.model.Formulario;

public class FormularioDAOImpl extends DaoGenericoImp<Formulario, Serializable> implements FormularioDAO {

	@Override
	public Formulario consultar(Integer codigo) {
		return super.pesquisarPorId(codigo);
	}

	@Override
	public Formulario atualizar(Formulario formulario) {
		return super.atualizar(formulario);
	}

	@Override
	public void inserir(Formulario formulario) {
		super.salvar(formulario);
	}

	@Override
	public Formulario consultarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Integer id) {
		Formulario f = consultar(id);
		return (f != null);
	}


	@Override
	public List<Formulario> listar() {
		return super.todos();
	}

}
