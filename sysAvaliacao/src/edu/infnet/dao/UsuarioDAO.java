package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

import edu.infnet.model.Usuario;

public interface UsuarioDAO extends Serializable {

	public abstract Usuario consultar(Integer codigo);

	//public abstract void atualizar(Usuario usuario);

	public abstract void inserir(Usuario usuario);

	public abstract void excluir(Usuario usuario);

	public abstract Usuario consultarPorNome(String nome);

	public abstract Usuario validarLogin(Usuario usuario) throws HibernateException;

	public abstract List<Usuario> listar();


}