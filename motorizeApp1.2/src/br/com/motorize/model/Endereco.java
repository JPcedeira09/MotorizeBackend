package br.com.motorize.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "endereco")
@XmlAccessorType(XmlAccessType.FIELD)
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id_endereco")
	private int id_endereco;
	@XmlAttribute(name = "estado")
	private int estado;
	@XmlAttribute(name = "id_cidade")
	private int id_cidade;
	@XmlAttribute(name = "cep")
	private String cep;
	@XmlAttribute(name = "rua")
	private String rua;
	@XmlAttribute(name = "numero")
	private String numero;
	@XmlAttribute(name = "complemento")
	private String complemento;
	@XmlAttribute(name = "bairro")
	private String bairro;
	@XmlAttribute(name = "id_pessoa_fk")
	private int id_pessoa_fk;

	public int getId_endereco() {
		return id_endereco;
	}

	public int getint() {
		return estado;
	}

	public void setint(int estado) {
		this.estado = estado;
	}

	public int getid_cidade() {
		return id_cidade;
	}

	public void setid_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getid_pessoa_fk() {
		return id_pessoa_fk;
	}

	public void setid_pessoa_fk(int id_pessoa_fk) {
		this.id_pessoa_fk = id_pessoa_fk;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	
	public Endereco() {
		super();
	}

	public Endereco(int id_endereco, int estado, int id_cidade, String cep, String rua, String numero,
			String complemento, String bairro, int id_pessoa_fk) {
		super();
		this.id_endereco = id_endereco;
		this.estado = estado;
		this.id_cidade = id_cidade;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.id_pessoa_fk = id_pessoa_fk;
	}

	public Endereco(int estado, int id_cidade, String cep, String rua, String numero, String complemento,
			String bairro, int id_pessoa_fk) {
		super();
		this.estado = estado;
		this.id_cidade = id_cidade;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.id_pessoa_fk = id_pessoa_fk;
	}

	@Override
	public String toString() {
		return "Endereco (" + id_endereco + ", " + estado + ", " + id_cidade + ", " + cep + ", " + rua + ", " + numero
				+ ", " + complemento + ", " + bairro + ", " + id_pessoa_fk + ")";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
