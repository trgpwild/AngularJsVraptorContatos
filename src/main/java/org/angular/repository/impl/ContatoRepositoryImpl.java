package org.angular.repository.impl;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.entity.Contato;
import org.angular.repository.ContatoRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ContatoRepositoryImpl extends RepositoryImpl<Contato, Long> implements ContatoRepository {

	/**
	 * 
	 * @param entityManager
	 * 
	 * Propriedade usando a injeção de dependência do vraptor
	 * 
	 */
	ContatoRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}