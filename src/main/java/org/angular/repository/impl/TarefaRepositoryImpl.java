package org.angular.repository.impl;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.entity.Tarefa;
import org.angular.repository.TarefaRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class TarefaRepositoryImpl extends RepositoryImpl<Tarefa, Long> implements TarefaRepository {

	/**
	 * 
	 * @param entityManager
	 * 
	 * Propriedade usando a injeção de dependência do vraptor
	 * 
	 */
	TarefaRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}