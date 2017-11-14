 package br.com.motorize.model;

import java.io.Serializable;

public class Tipo_Assinatura  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_tipo_assinatura;
	private String nome_assinatura;
	private String sigla_assinatura;
	private double valor;
	public int getId_tipo_assinatura() {
		return id_tipo_assinatura;
	}
	public void setId_tipo_assinatura(int id_tipo_assinatura) {
		this.id_tipo_assinatura = id_tipo_assinatura;
	}
	public String getNome_assinatura() {
		return nome_assinatura;
	}
	public void setNome_assinatura(String nome_assinatura) {
		this.nome_assinatura = nome_assinatura;
	}
	public String getSigla_assinatura() {
		return sigla_assinatura;
	}
	public void setSigla_assinatura(String sigla_assinatura) {
		this.sigla_assinatura = sigla_assinatura;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Tipo_Assinatura(int id_tipo_assinatura, String nome_assinatura, String sigla_assinatura, double valor) {
		super();
		this.id_tipo_assinatura = id_tipo_assinatura;
		this.nome_assinatura = nome_assinatura;
		this.sigla_assinatura = sigla_assinatura;
		this.valor = valor;
	}
	public Tipo_Assinatura() {
		super();
	}
	
	
}
