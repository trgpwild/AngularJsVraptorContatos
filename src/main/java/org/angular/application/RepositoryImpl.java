package org.angular.application;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public abstract class RepositoryImpl<T extends Entity, I extends Serializable> {
	
	protected final EntityManager entityManager;
	protected final Class<T> clazz;

	protected RepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.clazz = clazz;
	}
	
	public void insert(T entity) {
		entityManager.persist(entity);
	}
	
	public T update(T entity) {
		return entityManager.merge(entity);
	}
	
	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	public T find(I id) {
		return entityManager.find(clazz, id);
	}
	
	public List<T> findAll() {
		Query query = entityManager.createQuery(new StringBuilder("from ").append(clazz.getName()).toString());
		List<T> resultList = query.getResultList();
		return resultList;
	}
	
	public List<T> pagination(int first, int size, Map<String,String> filters) {
		
		StringBuilder queryString = new StringBuilder("select o from ").append(clazz.getSimpleName()).append(" o ");
		
		if (getDefaultOrderField() != null && getDefaultOrderField().length() > 0) {
			queryString.append(" order by ").append(getDefaultOrderField());
		}
		
		Query query = entityManager.createQuery(queryString.toString());
		
		query.setFirstResult(first);
		query.setMaxResults(size);
		
		return query.getResultList();
		
	}
	
	protected String getDefaultOrderField() {
		return null;
	}
	
}