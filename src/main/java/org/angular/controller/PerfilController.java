package org.angular.controller;

import org.angular.application.Controller;
import org.angular.model.Perfil;
import org.angular.repository.PerfilRepository;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("perfis")
public class PerfilController extends Controller {

	private PerfilRepository repository;

	public PerfilController(Result result, PerfilRepository repository) {
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
	public void insert(Perfil perfil) {
		repository.insert(perfil);
		result.nothing();
	}

	@Put
	@Path("/{perfil.id}")
	@Consumes("application/json")
	public void update(Perfil perfil) {
		repository.update(perfil);
		result.nothing();
	}

	@Put
	@Path("/{perfil.id}")
	public void delete(Perfil perfil) {
		repository.delete(perfil);
		result.nothing();
	}

}