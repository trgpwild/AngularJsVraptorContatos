package org.angular.repository.impl;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.model.Perfil;
import org.angular.repository.PerfilRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PerfilRepositoryImpl extends RepositoryImpl<Perfil, Long> implements PerfilRepository {

	PerfilRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}