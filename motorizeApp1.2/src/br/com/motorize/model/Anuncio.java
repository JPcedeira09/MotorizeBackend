package br.com.motorize.model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "anuncio")
@XmlAccessorType(XmlAccessType.FIELD)
public class Anuncio implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id_produto")
	private int id_produto;
	@XmlAttribute(name = "id_carro_fk")
	private int id_carro_fk;
	@XmlAttribute(name = "id_pessoa_fk")
	private int id_pessoa_fk;
	@XmlAttribute(name = "preco")
	private double preco;
	@XmlAttribute(name = "data_postagem")
	private Date data_postagem;
	@XmlAttribute(name = "ano_compra")
	private Date ano_compra;
	@XmlAttribute(name = "cor")
	private String cor;
	@XmlAttribute(name = "opcional")
	private String opcional;
	@XmlAttribute(name = "blindagem")
	private String blindagem;
	@XmlAttribute(name = "kilometragem")
	private int kilometragem;
	@XmlAttribute(name = "numero_portas")
	private int numero_portas;
	@XmlAttribute(name = "tipo_necessidade")
	private String tipo_necessidade;
	@XmlAttribute(name = "codigo")
	private String codigo;
	@XmlAttribute(name = "imagem_1")
	private InputStream imagem_1;
	@XmlAttribute(name = "imagem_2")
	private InputStream imagem_2;
	@XmlAttribute(name = "imagem_3")
	private InputStream imagem_3;
	@XmlAttribute(name = "imagem_4")
	private InputStream imagem_4;

	public int getId_produto() {
		return id_produto;
	}



	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}



	public int getId_carro_fk() {
		return id_carro_fk;
	}



	public void setId_carro_fk(int id_carro_fk) {
		this.id_carro_fk = id_carro_fk;
	}



	public int getId_pessoa_fk() {
		return id_pessoa_fk;
	}



	public void setId_pessoa_fk(int id_pessoa_fk) {
		this.id_pessoa_fk = id_pessoa_fk;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public Date getData_postagem() {
		return data_postagem;
	}



	public void setData_postagem(Date data_postagem) {
		this.data_postagem = data_postagem;
	}



	public Date getAno_compra() {
		return ano_compra;
	}



	public void setAno_compra(Date ano_compra) {
		this.ano_compra = ano_compra;
	}



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public String getOpcional() {
		return opcional;
	}



	public void setOpcional(String opcional) {
		this.opcional = opcional;
	}



	public String getBlindagem() {
		return blindagem;
	}



	public void setBlindagem(String blindagem) {
		this.blindagem = blindagem;
	}



	public int getKilometragem() {
		return kilometragem;
	}



	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}



	public int getNumero_portas() {
		return numero_portas;
	}



	public void setNumero_portas(int numero_portas) {
		this.numero_portas = numero_portas;
	}



	public String getTipo_necessidade() {
		return tipo_necessidade;
	}



	public void setTipo_necessidade(String tipo_necessidade) {
		this.tipo_necessidade = tipo_necessidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public InputStream getImagem_1() {
		return imagem_1;
	}

	public void setImagem_1(InputStream inputStream) {
		this.imagem_1 = inputStream;
	}

	public InputStream getImagem_2() {
		return imagem_2;
	}

	public void setImagem_2(InputStream imagem_2) {
		this.imagem_2 = imagem_2;
	}

	public InputStream getImagem_3() {
		return imagem_3;
	}

	public void setImagem_3(InputStream imagem_3) {
		this.imagem_3 = imagem_3;
	}

	public InputStream getImagem_4() {
		return imagem_4;
	}

	public void setImagem_4(InputStream imagem_4) {
		this.imagem_4 = imagem_4;
	}

	public Anuncio( int id_carro_fk, int id_pessoa_fk, double preco, Date data_postagem, Date ano_compra,
			String cor, String opcional, String blindagem, int kilometragem, int numero_portas, String tipo_necessidade,
			String codigo, InputStream imagem_1, InputStream imagem_2, InputStream imagem_3, InputStream imagem_4) {
		super();
		this.id_carro_fk = id_carro_fk;
		this.id_pessoa_fk = id_pessoa_fk;
		this.preco = preco;
		this.data_postagem = data_postagem;
		this.ano_compra = ano_compra;
		this.cor = cor;
		this.opcional = opcional;
		this.blindagem = blindagem;
		this.kilometragem = kilometragem;
		this.numero_portas = numero_portas;
		this.tipo_necessidade = tipo_necessidade;
		this.codigo = codigo;
		this.imagem_1 = imagem_1;
		this.imagem_2 = imagem_2;
		this.imagem_3 = imagem_3;
		this.imagem_4 = imagem_4;
	}
	public Anuncio() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Anuncio [id_produto=" + id_produto + ", id_carro_fk=" + id_carro_fk + ", id_pessoa_fk=" + id_pessoa_fk
				+ ", preco=" + preco + ", data_postagem=" + data_postagem + ", ano_compra=" + ano_compra + ", cor="
				+ cor + ", opcional=" + opcional + ", blindagem=" + blindagem + ", kilometragem=" + kilometragem
				+ ", numero_portas=" + numero_portas + ", tipo_necessidade=" + tipo_necessidade + ", codigo=" + codigo
				+ ", imagem_1=" + imagem_1 + ", imagem_2=" + imagem_2 + ", imagem_3=" + imagem_3 + ", imagem_4="
				+ imagem_4 + "]";
	}



	public String toJson() {
		return new Gson().toJson(this);
	}
}
