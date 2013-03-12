package edu.infnet.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface DaoGenerico<T, ID extends Serializable> {
	public Class<T> getObjectClass();
	public T salvar(T object);
	public T pesquisarPorId(ID id);
	public T atualizar(T object);
	public void excluir(T object);
	public List<T> todos();
	public List<T> listPesqParam(String query, Map<String, Object> params);
	public List<T> listPesqParam(String query, Map<String, Object> params, 
			int maximo, int atual);
	public List<T> listPesq(String query);
	public T pesqParam(String query, Map<String, Object> params);
	
}
