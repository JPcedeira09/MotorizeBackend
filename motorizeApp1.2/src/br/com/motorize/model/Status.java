package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "status")
public class Status implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "id_status")
	private int id_status;
	@XmlAttribute(name = "nome_status")
	private int nome_status;
	
	
	
	public int getId_status() {
		return id_status;
	}
	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	public int getNome_status() {
		return nome_status;
	}
	public void setNome_status(int nome_status) {
		this.nome_status = nome_status;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int id_status, int nome_status) {
		super();
		this.id_status = id_status;
		this.nome_status = nome_status;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
