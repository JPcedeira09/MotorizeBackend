package br.com.motorize.model;

import javax.xml.bind.annotation.XmlAttribute;

import com.google.gson.Gson;

public class Email {

	@XmlAttribute(name = "id_email")
	private int id_email;

	@XmlAttribute(name = "email")
	private String email;

	@XmlAttribute(name = "id_pessoa_fk")
	private int id_pessoa_fk;
	
	
    public int getId_email() {
		return id_email;
	}

	public void setId_email(int id_email) {
		this.id_email = id_email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_pessoa_fk() {
		return id_pessoa_fk;
	}

	public void setId_pessoa_fk(int id_pessoa_fk) {
		this.id_pessoa_fk = id_pessoa_fk;
	}

	@Override
	public String toString() {
		return "Email [id_email=" + id_email + ", email=" + email + ", id_pessoa_fk=" + id_pessoa_fk + "]";
	}

	public String toJson() {
        return new Gson().toJson(this);
    }
    
	public Email() {
		super();
	}

}
