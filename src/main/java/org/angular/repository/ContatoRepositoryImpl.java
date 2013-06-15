package org.angular.repository;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.model.Contato;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ContatoRepositoryImpl extends RepositoryImpl<Contato, Long> implements ContatoRepository {

	ContatoRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}