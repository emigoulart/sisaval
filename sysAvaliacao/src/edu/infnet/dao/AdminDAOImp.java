package edu.infnet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.infnet.model.Usuario;
import edu.infnet.util.ConAvalicaoFactory;

public class AdminDAOImp implements InterfaceAdminDAO {
	private Connection conexao;

	public AdminDAOImp() throws AvalicaoDAOException {
		try {
			conexao = ConAvalicaoFactory.abreConexao();
		} catch (Exception e) {
			throw new AvalicaoDAOException("Erro: " + e.getMessage());
		}
	}

	@Override
	public void salvar(Usuario admin) throws AvalicaoDAOException {
		PreparedStatement ps = null;
		Connection conexao = null;

		if (admin == null) {
			throw new AvalicaoDAOException("O valor passado não pode ser nulo");
		}

		try {
			String sql = "INSERT INTO administrador (adm_nome, adm_dtanasc, adm_endereco, adm_telefone, adm_email, adm_login, adm_senha, adm_tipo)"
					+ " VALUES(?,?,?,?,?,?,?,?)";
			conexao = this.conexao;
			ps = conexao.prepareStatement(sql);
			ps.setString(1, admin.getNome());
			ps.setDate(2, (Date) admin.getDtanasc());
			ps.setString(3, admin.getEndereco());
			ps.setString(4, admin.getTelefone());
			ps.setString(5, admin.getEmail());
			ps.setString(6, admin.getLogin());
			ps.setString(7, admin.getSenha());
			//ps.setString(8, admin.getTipo());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new AvalicaoDAOException("Erro ao inserir dados " + sqle);
		} finally {
			ConAvalicaoFactory.fechaConexao(conexao, ps);
		}

	}

	@Override
	public void atualizar(Usuario admin) throws AvalicaoDAOException {


	}

	@Override
	public void excluir(Usuario admin) throws AvalicaoDAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> todosAdministradores() throws AvalicaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario procuraAdministrador(Integer id)
			throws AvalicaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
