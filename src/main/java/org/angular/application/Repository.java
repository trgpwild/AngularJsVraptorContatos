package org.angular.application;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Repository<T extends Entity, I extends Serializable> {
	 
	void insert(T entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	T find(I id);
	
	List<T> findAll();
	
	List<T> pagination(int first, int size, Map<String,String> filters);
	
}
