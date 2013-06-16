package org.angular.controller;

import org.angular.application.Controller;
import org.angular.model.Tarefa;
import org.angular.repository.TarefaRepository;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.Serializer;

@Resource
@Path("tarefas")
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
		serializer(repository.find(id)).serialize();
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

	@Put
	@Path("/{tarefa.id}")
	public void delete(Tarefa tarefa) {
		repository.delete(tarefa);
		result.nothing();
	}
	
	@Override
	protected Serializer serializer(Object object) {
		return super.serializer(object).exclude(
			"usuario.username",
			"usuario.password",
			"usuario.email",
			"usuario.ativo",
			"usuario.tries",
			"usuario.perfis"
		);
	}

}