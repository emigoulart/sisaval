package edu.infnet.dao;

import java.util.List;

import edu.infnet.bean.Pessoa;

public interface InterfaceAdminDAO {
	
    void salvar(Pessoa admin) throws AvalicaoDAOException;
	
	void atualizar(Pessoa admin) throws AvalicaoDAOException;
	
	void excluir(Pessoa admin) throws AvalicaoDAOException;
	
	List<List> todosAdministradores() throws AvalicaoDAOException;
	
	Pessoa procuraAdministrador(Integer id) throws AvalicaoDAOException;
}
