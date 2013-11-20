package org.angular.controller;

import org.angular.application.Controller;
import org.angular.entity.Contato;
import org.angular.repository.ContatoRepository;
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
 * Controller da entidade Contato para crud utilizando restful
 * 
 * Perceba que a anotação @Consumes é utilizada pois a camada da view envia o objeto em formato json e o vraptor se encarrega de transformar em objeto
 *
 */
@Resource
@Path("contatos")
@SecRole(roles={"ROLE_ADMIN"}) //Configuração de permissão para a role de admin
public class ContatoController extends Controller {

	private ContatoRepository repository;

	public ContatoController(Result result, ContatoRepository repository) {
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
	public void insert(Contato contato) {
		repository.insert(contato);
		result.nothing();
	}

	@Put
	@Path("/{contato.id}")
	@Consumes("application/json")
	public void update(Contato contato) {
		repository.update(contato);
		result.nothing();
	}

	@Delete
	@Path("/{contato.id}")
	public void delete(Contato contato) {
		repository.delete(contato);
		result.nothing();
	}

}