package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Formulario;


public interface FormularioDAO {

	public abstract Formulario consultar(Integer codigo);

	public abstract Formulario atualizar(Formulario formulario);

	public abstract void inserir(Formulario formulario);

	public abstract Formulario consultarPorNome(String nome);

	public abstract boolean existe(Integer id);

	public abstract List<Formulario> listar();


}
