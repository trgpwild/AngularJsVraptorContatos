package org.angular.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="usuario")
@SuppressWarnings("serial")
public class Usuario extends org.angular.application.Entity {

	@NotEmpty
	@Column(name="login")
	private String username;

	@Column(name="senha")
	private String password;
	
	@NotEmpty
	@Column(name="email")
	private String email;

	@Column(name="ativo")
	private boolean ativo;

	@Column(name="tentativas_login")
	private int tries;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_perfil",
			joinColumns=@JoinColumn(name="id_usuario"),
			inverseJoinColumns=@JoinColumn(name="id_perfil"))
	private Set<Perfil> perfis;

	public Usuario() {
		setAtivo(true);
		setTries(0);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	@Override
	public String toString() {
		return username;
	}

}