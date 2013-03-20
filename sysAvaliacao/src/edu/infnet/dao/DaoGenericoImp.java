package edu.infnet.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class DaoGenericoImp<T, ID extends Serializable>
implements DaoGenerico<T, ID> {


	private EntityManager entityManager;

	private final Class<T> oClass;//object class

	@Override
	public Class<T> getObjectClass() {
		return this.oClass;
	}


	@PersistenceContext(unitName="sysAvaliacao")
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	protected EntityManager getEntityManager() {
		EntityManagerFactory emf;
		if (entityManager == null) {
			try{
				emf = Persistence.createEntityManagerFactory("sysAvaliacao");
				entityManager=emf.createEntityManager();
			}catch(IllegalStateException isexc){
				throw new IllegalStateException(isexc);
			}
		}
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public DaoGenericoImp() {
		this.oClass = (Class<T>)
				( (ParameterizedType) getClass().getGenericSuperclass() ).
				getActualTypeArguments()[0];

	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T atualizar(T object) {
		getEntityManager().merge(object);

		return object;

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void excluir(T object) {
		object = getEntityManager().merge(object);
		getEntityManager().remove(object);
	}



	@Override
	public T pesquisarPorId(ID id) {
		return getEntityManager().find(oClass, id);
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T salvar(T object) {
		getEntityManager().clear();
		getEntityManager().persist(object);
		//getEntityManager().flush();

		return object;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> todos(){
		String queryS = "SELECT obj FROM "+oClass.getSimpleName()+" obj";
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params){
		Query q = getEntityManager().createQuery(query);
		for(String chave : params.keySet()){
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params,
			int maximo, int atual){
		Query q = getEntityManager().
				createQuery(query).
				setMaxResults(maximo).
				setFirstResult(atual);

		for(String chave : params.keySet()){
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listPesq(String query){
		Query q = getEntityManager().createQuery(query);
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T pesqParam(String query, Map<String, Object> params){
		Query q = getEntityManager().createQuery(query);
		for(String chave : params.keySet()){
			q.setParameter(chave, params.get(chave));

		}
		try{
			return (T) q.getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}

}
