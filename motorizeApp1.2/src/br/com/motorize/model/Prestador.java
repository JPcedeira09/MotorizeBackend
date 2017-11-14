package br.com.motorize.model;

import java.io.Serializable;
import java.sql.Time;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "prestador")
public class Prestador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "id_pessoa_fk")
	private int id_pessoa_fk;
	@XmlAttribute(name = "nome")
	private String nome;
	@XmlAttribute(name = "nome_fantasia")
	private String nome_fantasia;
	@XmlAttribute(name = "CNPJ")
	private String CNPJ;
	@XmlAttribute(name = "senha")
	private String senha;
	@XmlAttribute(name = "hora_abertura")
	private Time hora_abertura;
	@XmlAttribute(name = "hora_fechamento")
	private Time hora_fechamento;
	@XmlAttribute(name = "telefone")
	private String telefone;
	@XmlAttribute(name = "celular")
	private String celular;
	@XmlAttribute(name = "tipo_prestador")
	private String tipo_prestador;

	
    public int getId_pessoa_fk() {
		return id_pessoa_fk;
	}



	public void setId_pessoa_fk(int id_pessoa_fk) {
		this.id_pessoa_fk = id_pessoa_fk;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getNome_fantasia() {
		return nome_fantasia;
	}



	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}



	public String getCNPJ() {
		return CNPJ;
	}



	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public Time getHora_abertura() {
		return hora_abertura;
	}



	public void setHora_abertura(Time hora_abertura) {
		this.hora_abertura = hora_abertura;
	}



	public Time getHora_fechamento() {
		return hora_fechamento;
	}



	public void setHora_fechamento(Time hora_fechamento) {
		this.hora_fechamento = hora_fechamento;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getTipo_prestador() {
		return tipo_prestador;
	}



	public void setTipo_prestador(String tipo_prestador) {
		this.tipo_prestador = tipo_prestador;
	}



	
	public Prestador(int id_pessoa_fk, String nome, String nome_fantasia, String cNPJ, String senha, Time hora_abertura,
			Time hora_fechamento, String telefone, String celular, String tipo_prestador) {
		super();
		this.id_pessoa_fk = id_pessoa_fk;
		this.nome = nome;
		this.nome_fantasia = nome_fantasia;
		CNPJ = cNPJ;
		this.senha = senha;
		this.hora_abertura = hora_abertura;
		this.hora_fechamento = hora_fechamento;
		this.telefone = telefone;
		this.celular = celular;
		this.tipo_prestador = tipo_prestador;
	}



	public Prestador() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String toJson() {
        return new Gson().toJson(this);
    }
}
