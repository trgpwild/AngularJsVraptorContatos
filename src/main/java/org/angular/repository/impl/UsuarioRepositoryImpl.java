package org.angular.repository.impl;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.model.Usuario;
import org.angular.repository.UsuarioRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class UsuarioRepositoryImpl extends RepositoryImpl<Usuario, Long> implements UsuarioRepository {

	UsuarioRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}