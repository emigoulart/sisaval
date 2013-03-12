package edu.infnet.dao;

import java.util.List;

import edu.infnet.model.Usuario;



public interface InterfaceAdminDAO {
	
    void salvar(Usuario admin) throws AvalicaoDAOException;
	
	void atualizar(Usuario admin) throws AvalicaoDAOException;
	
	void excluir(Usuario admin) throws AvalicaoDAOException;
	
	List<List> todosAdministradores() throws AvalicaoDAOException;
	
	Usuario procuraAdministrador(Integer id) throws AvalicaoDAOException;
}
