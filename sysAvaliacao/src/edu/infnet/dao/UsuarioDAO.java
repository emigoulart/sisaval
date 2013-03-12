package edu.infnet.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import edu.infnet.model.Usuario;

public interface UsuarioDAO {

	public abstract Usuario consultar(Integer codigo);

	//public abstract void atualizar(Usuario usuario);

	public abstract void inserir(Usuario usuario);

	public abstract void excluir(Usuario usuario);

	public abstract void excluir(Integer codigo);

	//public abstract Usuario consultar(Criterio criterio);

	public abstract Usuario consultarPorNome(String nome);

	public abstract boolean existe(Integer id);

	public abstract boolean validarLogin(Usuario usuario) throws HibernateException;

	public abstract Usuario consultarPorNome(Session session, String nome);

	public abstract List<Usuario> listar();


}