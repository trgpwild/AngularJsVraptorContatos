package org.angular.security.controller;

import org.angular.application.Controller;
import org.angular.entity.Usuario;
import org.angular.repository.UsuarioRepository;
import org.angular.security.entity.Login;
import org.angular.security.entity.SecurityResponse;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("authentication")
public class LoginController extends Controller {

	private Login login;
	
	private UsuarioRepository repository;
	
	public LoginController(Result result, UsuarioRepository repository, Login login) {
		super(result);
		this.repository = repository;
		this.login = login;
	}
	
	@Post
	@Path("/login/")
	@Consumes("application/json")
	public void login(Usuario usuario) {
		boolean authenticated = false; String message = "";
		Usuario u = repository.getByUsernameAndPassword(
			usuario.getUsername(), 
			usuario.getPassword()
		);
		if (u != null) {
			login.setUsuario(u);
			authenticated = true;
			message = "AUTHENTICATED";
		} else {
			authenticated = false;
			message = "NOT_AUTHENTICATED";
		}
		serializer(new SecurityResponse(authenticated, message)).serialize();
	}

	@Get
	@Path("/logout/")
	public void logout() {
		login.setUsuario(null);
		serializer(new SecurityResponse(false, "NOT_AUTHENTICATED")).serialize();
	}
	
}
