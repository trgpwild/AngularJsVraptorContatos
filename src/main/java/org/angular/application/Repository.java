package org.angular.application;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.angular.model.Contato;
import org.angular.model.Entity;


public interface Repository<T extends Entity, I extends Serializable> {
	 
	void insert(T entity);
	
	Contato update(T entity);
	
	void remove(T entity);
	
	Contato find(I id);
	
	List<T> findAll();
	
	List<T> getListPagination(int first, int size, Map<String,String> filters);
	
}
