package br.com.motorize.model;

import java.io.Serializable;
import java.sql.Time;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "serviço")
public class Servico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@XmlAttribute(name = "id_serviço")
	private int id_serviço;
	@XmlAttribute(name = "id_pessoa_prest_fk")
	private int id_pessoa_prest_fk;
	@XmlAttribute(name = "nome_servico")
	private String nome_servico;
	@XmlAttribute(name = "valor_servico")
	private double valor_servico;
	@XmlAttribute(name = "tipo_servico")
	private String tipo_servico;
	@XmlAttribute(name = "tempo_estimado")
	private Time tempo_estimado;
	@XmlAttribute(name = "aberto")
	private int aberto;
	@XmlAttribute(name = "abertura")
	private Time abertura;
	@XmlAttribute(name = "fechamento")
	private Time fechamento;
	@XmlAttribute(name = "descricao")
	private String descricao;
	@XmlAttribute(name = "diferencial")
	private String diferencial;
	@XmlAttribute(name = "codigo")
	private String codigo;

	
	
	public int getId_serviço() {
		return id_serviço;
	}



	public void setId_serviço(int id_serviço) {
		this.id_serviço = id_serviço;
	}



	public int getId_pessoa_prest_fk() {
		return id_pessoa_prest_fk;
	}



	public void setId_pessoa_prest_fk(int id_pessoa_prest_fk) {
		this.id_pessoa_prest_fk = id_pessoa_prest_fk;
	}



	public String getNome_servico() {
		return nome_servico;
	}



	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}



	public double getValor_servico() {
		return valor_servico;
	}



	public void setValor_servico(double valor_servico) {
		this.valor_servico = valor_servico;
	}



	public String getTipo_servico() {
		return tipo_servico;
	}



	public void setTipo_servico(String tipo_servico) {
		this.tipo_servico = tipo_servico;
	}



	public Time getTempo_estimado() {
		return tempo_estimado;
	}



	public void setTempo_estimado(Time tempo_estimado) {
		this.tempo_estimado = tempo_estimado;
	}



	public int getAberto() {
		return aberto;
	}



	public void setAberto(int aberto) {
		this.aberto = aberto;
	}



	public Time getAbertura() {
		return abertura;
	}



	public void setAbertura(Time abertura) {
		this.abertura = abertura;
	}



	public Time getFechamento() {
		return fechamento;
	}



	public void setFechamento(Time fechamento) {
		this.fechamento = fechamento;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getDiferencial() {
		return diferencial;
	}



	public void setDiferencial(String diferencial) {
		this.diferencial = diferencial;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Servico(int id_serviço, int id_pessoa_prest_fk, String nome_servico, double valor_servico, String tipo_servico,
			Time tempo_estimado, int aberto, Time abertura, Time fechamento, String descricao, String diferencial, String codigo) {
		super();
		this.id_serviço = id_serviço;
		this.id_pessoa_prest_fk = id_pessoa_prest_fk;
		this.nome_servico = nome_servico;
		this.valor_servico = valor_servico;
		this.tipo_servico = tipo_servico;
		this.tempo_estimado = tempo_estimado;
		this.aberto = aberto;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.descricao = descricao;
		this.diferencial = diferencial;
		this.codigo = codigo;
	}



	public Servico() {
		super();
	}



	public String toJson() {
		return new Gson().toJson(this);
	}
}
