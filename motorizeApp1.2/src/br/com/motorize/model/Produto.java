package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "produto")
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "id_produto")
	private int id_produto;
	@XmlAttribute(name = "id_pessoa_prest_fk")
	private int id_pessoa_prest_fk;
	@XmlAttribute(name = "nome")
	private String nome;
	@XmlAttribute(name = "codigo")
	private String codigo;
	@XmlAttribute(name = "descricao")
	private String descricao;
	@XmlAttribute(name = "preco")
	private double preco;
	@XmlAttribute(name = "entrega")
	private int entrega;
	@XmlAttribute(name = "quantidade")
	private int quantidade;
	@XmlAttribute(name = "disponibilidade")
	private int disponibilidade;
	@XmlAttribute(name = "tipo_produto")
	private String tipo_produto;
	@XmlAttribute(name = "marca")
	private String marca;
	
	
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public int getId_pessoa_prest_fk() {
		return id_pessoa_prest_fk;
	}
	public void setId_pessoa_prest_fk(int id_pessoa_prest_fk) {
		this.id_pessoa_prest_fk = id_pessoa_prest_fk;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEntrega() {
		return entrega;
	}
	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(int disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String getTipo_produto() {
		return tipo_produto;
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produto(int id_produto, int id_pessoa_prest_fk, String nome, String codigo, String descricao, double preco, int entrega,
			int quantidade, int disponibilidade, String tipo_produto, String marca) {
		super();
		this.id_produto = id_produto;
		this.id_pessoa_prest_fk = id_pessoa_prest_fk;
		this.nome = nome;
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.entrega = entrega;
		this.quantidade = quantidade;
		this.disponibilidade = disponibilidade;
		this.tipo_produto = tipo_produto;
		this.marca = marca;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
