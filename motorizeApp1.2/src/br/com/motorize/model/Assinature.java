package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "assinatura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Assinature implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id_assinatura")
	private int id_assinatura;
	@XmlAttribute(name = "id_pessoa_fk")
	private int id_pessoa_fk;
	@XmlAttribute(name = "id_tipoAssinatura")
	private int id_tipoAssinatura;
	@XmlAttribute(name = "id_status")
	private int id_status;


	public int getId_assinatura() {
		return id_assinatura;
	}

	public void setId_assinatura(int id_assinatura) {
		this.id_assinatura = id_assinatura;
	}

	public int getId_tipoAssinatura() {
		return id_tipoAssinatura;
	}

	public void setId_tipoAssinatura(int id_tipoAssinatura) {
		this.id_tipoAssinatura = id_tipoAssinatura;
	}

	public int getid_status() {
		return id_status;
	}

	public void setid_status(int id_status) {
		this.id_status = id_status;
	}

	public int getId_pessoa_fk() {
		return id_pessoa_fk;
	}

	public void setId_pessoa_fk(int id_pessoa_fk) {
		this.id_pessoa_fk = id_pessoa_fk;
	}


	public Assinature() {
		super();
	}

	
/**
 * 
 * @param id_pessoa_fk
 * @param id_tipoAssinatura
 * @param id_status
 */
	public Assinature(int id_pessoa_fk, int id_tipoAssinatura, int id_status) {
		super();
		this.id_pessoa_fk = id_pessoa_fk;
		this.id_tipoAssinatura = id_tipoAssinatura;
		this.id_status = id_status;
	}

	/**
	 * 
	 * @param id_assinatura
	 * @param id_pessoa_fk
	 * @param id_tipoAssinatura
	 * @param id_status
	 */
	public Assinature(int id_assinatura, int id_pessoa_fk, int id_tipoAssinatura, int id_status) {
		super();
		this.id_assinatura = id_assinatura;
		this.id_pessoa_fk = id_pessoa_fk;
		this.id_tipoAssinatura = id_tipoAssinatura;
		this.id_status = id_status;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
