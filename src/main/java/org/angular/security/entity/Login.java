package org.angular.security.entity;

import org.angular.entity.Usuario;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * 
 * @author trgp
 *
 * Classe que define o objeto a ser persistido em sessão para auntentição na aplicação
 *
 */
@Component
@SessionScoped
public class Login {

	private Usuario usuario;
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}