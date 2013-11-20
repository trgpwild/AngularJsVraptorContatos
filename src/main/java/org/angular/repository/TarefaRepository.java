package org.angular.repository;

import org.angular.application.Repository;
import org.angular.entity.Tarefa;

/**
 * 
 * @author trgp
 *
 * Essa seria a tradicional camada de DAOs, mas para questões conceituais, como não tocamos 
 * diretamente em código de banco de dados por termos o hibernate para tal, o pattern Repository 
 * é o mais indicado. Em outras palavras, uma camada Repository também pode ser chamada de DAO, 
 * mas o inverso não é verdadeiro.
 * 
 */
public interface TarefaRepository extends Repository<Tarefa, Long> {
	 
}