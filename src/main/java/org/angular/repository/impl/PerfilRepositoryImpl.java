package org.angular.repository.impl;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.entity.Perfil;
import org.angular.repository.PerfilRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PerfilRepositoryImpl extends RepositoryImpl<Perfil, Long> implements PerfilRepository {

	/**
	 * 
	 * @param entityManager
	 * 
	 * Propriedade usando a injeção de dependência do vraptor
	 * 
	 */
	PerfilRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}