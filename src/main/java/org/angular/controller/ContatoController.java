package org.angular.controller;

import org.angular.application.Controller;
import org.angular.repository.ContatoRepository;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("contatos")
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

}