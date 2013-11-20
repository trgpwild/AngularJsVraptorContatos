package org.angular.controller;

import org.angular.application.Controller;
import org.angular.entity.Usuario;
import org.angular.repository.UsuarioRepository;
import org.angular.security.Hasher;
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
 * Controller da entidade Usuario para crud utilizando restful
 *
 * Perceba que a anotação @Consumes é utilizada pois a camada da view envia o objeto em formato json e o vraptor se encarrega de transformar em objeto
 *
 */
@Resource
@Path("usuarios")
@SecRole(roles={"ROLE_ADMIN"}) //Configuração de permissão para a role de admin
public class UsuarioController extends Controller {

	private UsuarioRepository repository;

	public UsuarioController(Result result, UsuarioRepository repository) {
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
	public void insert(Usuario usuario) {
		usuario.setPassword(Hasher.get(usuario.getPassword()));
		repository.insert(usuario);
		result.nothing();
	}

	@Put
	@Path("/{usuario.id}")
	@Consumes("application/json")
	public void update(Usuario usuario) {
		usuario.setPassword(Hasher.get(usuario.getPassword()));
		repository.update(usuario);
		result.nothing();
	}

	@Delete
	@Path("/{usuario.id}")
	public void delete(Usuario usuario) {
		repository.delete(usuario);
		result.nothing();
	}

	@Override
	protected String[] excludeProps() {
		return new String[] {"password","perfis.authority"};
	}
	
}