package org.angular.security.entity;

/**
 * 
 * @author trgp
 *
 * Classe que define o DTO para response das requisições de autenticação e autorização da aplicação
 *
 */
public class SecurityResponse {

	private boolean authenticated;
	private String message;
	
	public SecurityResponse(boolean authenticated, String message) {
		this.authenticated = authenticated;
		this.message = message;
	}
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	
	public String getMessage() {
		return message;
	}

}
