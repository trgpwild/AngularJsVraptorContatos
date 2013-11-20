package org.angular.controller;

import org.angular.application.Controller;
import org.angular.entity.Tarefa;
import org.angular.repository.TarefaRepository;
import org.angular.security.SecRole;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * 
 * @author trgp
 *
 * Controller da entidade Tarefa para crud utilizando restful
 *
 * Perceba que a anotação @Consumes é utilizada pois a camada da view envia o objeto em formato json e o vraptor se encarrega de transformar em objeto
 *
 */
@Resource
@Path("tarefas")
@SecRole(roles={"ROLE_ADMIN"}) //Configuração de permissão para a role de admin
public class TarefaController extends Controller {

	private TarefaRepository repository;

	public TarefaController(Result result, TarefaRepository repository) {
		super(result);
		this.repository = repository;
	}

	@Get
	@Path({"","/"})
	public void list() {
		serializer(repository.findAll()).serialize();
	}

	@Get
	@Path("/{start}/{limit}")
	public void list(Integer start, Integer limit) {
		serializer(repository.pagination(start, limit, null)).serialize();
	}

	@Get
	@Path("/{id}")
	public void find(Long id) {
		serializer(repository.find(id),true).serialize();
	}

	@Post
	@Path({"","/"})
	@Consumes("application/json")
	public void insert(Tarefa tarefa) {
		repository.insert(tarefa);
		result.nothing();
	}

	@Put
	@Path("/{tarefa.id}")
	@Consumes("application/json")
	public void update(Tarefa tarefa) {
		repository.update(tarefa);
		result.nothing();
	}

	@Delete
	@Path("/{tarefa.id}")
	public void delete(Tarefa tarefa) {
		repository.delete(tarefa);
		result.nothing();
	}

	@Override
	protected String[] excludeProps() {
		return new String[]{
			"usuario.username",
			"usuario.password",
			"usuario.email",
			"usuario.ativo",
			"usuario.tries",
			"usuario.perfis"
		};
	}

}