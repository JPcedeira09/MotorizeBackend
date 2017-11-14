package br.com.motorize.model;

public class Estado {
	private int id_estado;
	private String estado;
	private String sigla;
	public int getId_estado() {
		return id_estado;
	}
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Estado(int id_estado, String estado, String sigla) {
		super();
		this.id_estado = id_estado;
		this.estado = estado;
		this.sigla = sigla;
	}
	public Estado() {
		super();
	}
	
	
}
