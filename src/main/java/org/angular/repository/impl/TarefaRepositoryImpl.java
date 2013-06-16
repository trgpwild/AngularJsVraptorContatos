package org.angular.repository.impl;

import javax.persistence.EntityManager;

import org.angular.application.RepositoryImpl;
import org.angular.model.Tarefa;
import org.angular.repository.TarefaRepository;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class TarefaRepositoryImpl extends RepositoryImpl<Tarefa, Long> implements TarefaRepository {

	TarefaRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

}