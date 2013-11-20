package org.angular.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.angular.application.RepositoryImpl;
import org.angular.entity.Usuario;
import org.angular.repository.UsuarioRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
@SuppressWarnings("unchecked")
public class UsuarioRepositoryImpl extends RepositoryImpl<Usuario, Long> implements UsuarioRepository {

	/**
	 * 
	 * @param entityManager
	 * 
	 * Propriedade usando a injeção de dependência do vraptor
	 * 
	 */
	UsuarioRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Usuario getByUsernameAndPassword(String username, String password) {

		/*
		 * Mais uma vez, esse código não toca no sql nativo, por isso pode ser chamado de Repository pattern
		 */
		StringBuilder queryString = new StringBuilder("from Usuario where username = ? and password = ?");

		Query query = entityManager.createQuery(queryString.toString());
		
		query.setParameter(1, username);
		query.setParameter(2, password);
		
		List<Usuario> list = query.getResultList();
		
		if (!list.isEmpty()) {
			
			return list.get(0);
			
		} else {
			
			return null;
			
		}
		
	}

}