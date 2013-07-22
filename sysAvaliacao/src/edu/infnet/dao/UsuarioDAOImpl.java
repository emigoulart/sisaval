package edu.infnet.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.infnet.model.Usuario;

@Repository
public class UsuarioDAOImpl extends DaoGenericoImp<Usuario, Serializable> implements UsuarioDAO {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger
			.getLogger(UsuarioDAOImpl.class);


	@Override
	public void excluir(Usuario usuario) {
		super.excluir(usuario);
	}


	@Override
	public Usuario consultarPorNome(String nome) {
		return new Usuario();
	}

	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#validarLogin(br.edu.infnet.modelo.Usuario)
	 */
	@Override
	@Transactional
	public Usuario validarLogin(Usuario usuario) throws HibernateException{
		Query query=null;
		Usuario user= new Usuario();
		try {
			EntityManager entityManager=getEntityManager();
			String sqlQuery = "from Usuario where login = :login and senha = :senha ";
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("login", usuario.getLogin());
			parameters.put("senha", usuario.getSenha());

			query = entityManager.createQuery(sqlQuery);

			if (parameters != null) {
				for (final Map.Entry<String, Object> param : parameters.entrySet()) {
					query.setParameter(param.getKey(), param.getValue());
				}
			}


		} catch (HibernateException exc) {
			LOGGER.error(exc);
			throw new HibernateException(exc);

		}

		if(!query.getResultList().isEmpty()){
			user= (Usuario)query.getSingleResult();
		}
		
		return user;
	}


	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#listar()
	 */
	@Override
	public List<Usuario> listar() {
		return super.todos();

	}



	@Override
	public Usuario consultar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void inserir(Usuario usuario) {
		super.salvar(usuario);

	}



}
