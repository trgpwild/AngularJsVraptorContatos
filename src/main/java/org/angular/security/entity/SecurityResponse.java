package org.angular.security.entity;

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
