package br.com.motorize.model;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "anunciante")
public class Anunciante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "nome")
	private String nome;
	@XmlAttribute(name = "CPF")
	private String CPF;
	@XmlAttribute(name = "senha")
	private String senha;
	@XmlAttribute(name = "ano_nascimento")
	private Date ano_nascimento;
	@XmlAttribute(name = "telefone")
	private String telefone;
	@XmlAttribute(name = "celular")
	private String celular;
	@XmlAttribute(name = "tipo_pessoa")
	private String tipo_pessoa;
	@XmlAttribute(name = "id_pessoa")
	private int id_pessoa = 0 ;
	@XmlAttribute(name = "status")
	private String status  ;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getAno_nascimento() {
		return ano_nascimento;
	}
	public void setAno_nascimento(Date ano_nascimento) {
		this.ano_nascimento = ano_nascimento;
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
	public String getTipo_pessoa() {
		return tipo_pessoa;
	}
	public void setTipo_pessoa(String tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}
	public int getid_pessoa() {
		return id_pessoa;
	}
	public void setid_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Anunciante() {
		super();
	}
	/**
	 * Esse inicializador é para que o anunciante seja instanciado com sua chave id_pessoa
	 * inicializada ja com valor do banco de dados;
	 * 
	 * @param nome
	 * @param cPF
	 * @param senha
	 * @param ano_nascimento
	 * @param telefone
	 * @param celular
	 * @param tipo_pessoa
	 * @param id_pessoa
	 * @param status
	 */
	public Anunciante(String nome, String cPF, String senha, Date ano_nascimento, String telefone, String celular,
			String tipo_pessoa, int id_pessoa, String status) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.senha = senha;
		this.ano_nascimento = ano_nascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.tipo_pessoa = tipo_pessoa;
		this.id_pessoa = id_pessoa;
		this.status = status;
	}
	
	/**
	 * Esse inicializador é para Cadastro aonde não é preciso ser inicializado o id_pessoa
	 * pois ele é uma chave primaria auto incremental não precisa ser adicionado com valor;
	 * @param nome
	 * @param cPF
	 * @param senha
	 * @param ano_nascimento
	 * @param telefone
	 * @param celular
	 * @param tipo_pessoa
	 * @param status
	 */
	public Anunciante(String nome, String cPF, String senha, Date ano_nascimento, String telefone, String celular,
			String tipo_pessoa, String status) {
		super();
		this.nome = nome;
		this.CPF = cPF;
		this.senha = senha;
		this.ano_nascimento = ano_nascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.tipo_pessoa = tipo_pessoa;
		this.status = status;
	}
	
	

	@Override
	public String toString() {
		return "Anunciante [nome=" + nome + ", CPF=" + CPF + ", senha=" + senha + ", ano_nascimento=" + ano_nascimento
				+ ", telefone=" + telefone + ", celular=" + celular + ", tipo_pessoa=" + tipo_pessoa + ", id_pessoa="
				+ id_pessoa + ", status=" + status + "]";
	}
		
}
