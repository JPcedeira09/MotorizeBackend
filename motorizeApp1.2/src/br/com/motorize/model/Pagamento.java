package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "Pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id_assinatura")
	private int id_assinatura;

	@XmlAttribute(name = "id_status")
	private int id_status;


	public int getid_assinatura() {
		return id_assinatura;
	}

	public void setid_assinatura(int id_assinatura) {
		this.id_assinatura = id_assinatura;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

	
	public Pagamento(int id_assinatura, int id_status) {
		super();
		this.id_assinatura = id_assinatura;
		this.id_status = id_status;
	}

	public Pagamento() {
		super();
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
