package org.angular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="perfil")
@SuppressWarnings("serial")
public class Perfil extends org.angular.application.Entity {

	@NotEmpty
	@Column(name="descricao")
	private String authority;
	
	public String getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return authority;
	}

}