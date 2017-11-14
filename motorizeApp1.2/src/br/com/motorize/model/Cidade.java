package br.com.motorize.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.google.gson.Gson;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cidade {

	@XmlAttribute(name = "id_estado")
	private int id_estado;

	@XmlAttribute(name = "id_cidade")
	private int id_cidade;

	@XmlAttribute(name = "cidade")
	private String cidade;

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	public int getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getcidade() {
		return cidade;
	}

	public void setcidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cidade (" + id_estado + ", " + id_cidade + ", " + cidade + ")";
	}

	public Cidade(int id_estado, int id_cidade, String cidade) {
		super();
		this.id_estado = id_estado;
		this.id_cidade = id_cidade;
		this.cidade = cidade;
	}

	public Cidade() {
		super();
	}
    public String toJson() {
        return new Gson().toJson(this);
    }
}
