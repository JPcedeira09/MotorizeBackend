
package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "veiculo")
public class Veiculo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@XmlAttribute(name = "id_carro")
	private int id_carro;
	@XmlAttribute(name = "marca")
	private String marca;
	@XmlAttribute(name = "modelo")
	private String modelo;
	@XmlAttribute(name = "versao")
	private String versao;
	@XmlAttribute(name = "tipo_veiculo")
	private String tipo_veiculo;
	
	public int getId_carro() {
		return id_carro;
	}
	public void setId_carro(int id_carro) {
		this.id_carro = id_carro;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getTipo_veiculo() {
		return tipo_veiculo;
	}
	public void setTipo_veiculo(String tipo_veiculo) {
		this.tipo_veiculo = tipo_veiculo;
	}
	
	/**
	 * @param id_carro
	 * @param marca
	 * @param modelo
	 * @param versao
	 * @param tipo_veiculo
	 */
	public Veiculo(int id_carro, String marca, String modelo, String versao, String tipo_veiculo) {
		super();
		this.id_carro = id_carro;
		this.marca = marca;
		this.modelo = modelo;
		this.versao = versao;
		this.tipo_veiculo = tipo_veiculo;
	}
	public Veiculo() {
		super();
	}
	@Override
	public String toString() {
		return "Veiculo [id_carro=" + id_carro + ", marca=" + marca + ", modelo=" + modelo + ", versao=" + versao
				+ ", tipo_veiculo=" + tipo_veiculo + "]";
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
	

}
