package org.angular.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tarefa")
@SuppressWarnings("serial")
public class Tarefa extends org.angular.application.Entity {

	@NotEmpty
	@Column(name="nome")
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataExecucao;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataExecucao() {
		return dataExecucao;
	}
	
	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return getNome();
	}

}