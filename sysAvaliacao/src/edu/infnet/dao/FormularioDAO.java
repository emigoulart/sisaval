package edu.infnet.dao;

import edu.infnet.model.Formulario;
import java.util.List;

import org.hibernate.Session;


public interface FormularioDAO {
	
	public abstract Formulario consultar(Integer codigo);

	public abstract Formulario atualizar(Formulario formulario);

	public abstract void inserir(Formulario formulario);

	public abstract Formulario consultarPorNome(String nome);

	public abstract boolean existe(Integer id);

	public abstract Formulario consultarPorNome(Session session, String nome);

	public abstract List<Formulario> listar();

	
}
