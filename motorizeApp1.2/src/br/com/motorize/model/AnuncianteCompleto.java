package br.com.motorize.model;

import java.io.Serializable;

public class AnuncianteCompleto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Anunciante anunciante ;
	private Endereco endereco ;
	private Cidade cidade ;
	private Estado estado ;
	private Email email ;
	private Assinature Assinature ;
	public Anunciante getAnunciante() {
		return anunciante;
	}
	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Assinature getAssinature() {
		return Assinature;
	}
	public void setAssinature(Assinature Assinature) {
		this.Assinature = Assinature;
	}
	public AnuncianteCompleto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnuncianteCompleto(Anunciante anunciante, Endereco endereco, Cidade cidade, Estado estado, Email email,
			Assinature Assinature) {
		super();
		this.anunciante = anunciante;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.Assinature = Assinature;
	}

	

	
}
