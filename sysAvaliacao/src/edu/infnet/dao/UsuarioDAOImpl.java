package edu.infnet.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.infnet.model.Usuario;


public class UsuarioDAOImpl extends DaoGenericoImp<Usuario, Serializable> implements UsuarioDAO {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger
			.getLogger(UsuarioDAOImpl.class);

	@Autowired
	public UsuarioDAOImpl() {
		//super(UsuarioDAOImpl.class);
	}


	@Override
	public Usuario consultar(Integer codigo) {
		return null;
		//super.consultar(codigo);
	}


	@Override
	public void inserir(Usuario usuario) {
		//super.incluir(usuario);
	}


	@Override
	public void excluir(Usuario usuario) {
		//super.deletar(usuario);
	}


	@Override
	public void excluir(Integer matricula) {
		//super.deletar(new Usuario(codigo));
	}


	@Override
	public Usuario consultarPorNome(String nome) {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#existe(java.lang.Integer)
	 */
	@Override
	public boolean existe(Integer id) {
		Usuario u = consultar(id);
		return (u != null);
	}

	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#validarLogin(br.edu.infnet.modelo.Usuario)
	 */
	@Override
	public boolean validarLogin(Usuario usuario){
		Query query=null;
		boolean encontrado= false;
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


		} catch (Exception exc) {
			LOGGER.error(exc);
			throw new HibernateException(exc);

		}
		encontrado= !query.getResultList().isEmpty();

		return encontrado;
	}

	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#consultarPorNome(org.hibernate.Session, java.lang.String)
	 */
	@Override
	public Usuario consultarPorNome(Session session, String nome) {

		if (nome == null) {
			return null;
		}

		/*	List<Usuario> lista = new ArrayList<Usuario>();
		try {
			String sql = "from Usuario where lower(nome) = ?";

			Criterio criterio = new Criterio();

			Query query = session.createQuery(sql);
			query.setString(0, nome.toLowerCase());
			query.setFirstResult(criterio.getRegistroInicial());
			query.setMaxResults(criterio.getTamanhoPagina());
			lista = (List<Usuario>) query.list();

		} catch (Exception e) {
			LOGGER.error(e);
		}

		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.get(0);
		}*/
		return null;
	}

	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#listar()
	 */
	@Override
	public List<Usuario> listar() {
		/*	Criterio c = new Criterio();
		c.setTotalRegistros(MAXIMO_REGISTROS);
		c.setTamanhoPagina(MAXIMO_REGISTROS);
		c.setRegistroInicial(1);
		//return listar(c);
		 */		return null;
	}

	/* (non-Javadoc)
	 * @see br.eud.infnet.dao.UsuarioDAO2#listar(br.eud.infnet.dao.hibernate.Criterio)

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(Criterio criterio) {

		List<Usuario> lista = new ArrayList<Usuario>();
		Session session = getSession();
		try {
			String sql = "from Usuario";

			Query query = session.createQuery(sql);
			query.setFirstResult(criterio.getRegistroInicial());
			query.setMaxResults(criterio.getTamanhoPagina());
			lista = (List<Usuario>) query.list();

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return lista;
	}*/

}
