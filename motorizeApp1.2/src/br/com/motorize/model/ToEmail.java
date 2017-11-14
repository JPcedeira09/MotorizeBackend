package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.google.gson.Gson;

@XmlAccessorType(XmlAccessType.FIELD)
public class ToEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id_email")
	private int id_email;

	@XmlAttribute(name = "email")
	private String email;

	@XmlAttribute(name = "id_anunciante")
	private int id_anunciante;

	@XmlAttribute(name = "mailTo")
	private String mailTo;

	@XmlAttribute(name = "subject")
	private String subject;

	@XmlAttribute(name = "msg")
	private String msg;

	public int getId_email() {
		return id_email;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public int getId_anunciante() {
		return id_anunciante;
	}

	public void setId_anunciante(int id_anunciante) {
		this.id_anunciante = id_anunciante;
	}

	public ToEmail(int id_email, String email, int id_anunciante) {
		super();
		this.id_email = id_email;
		this.email = email;
		this.id_anunciante = id_anunciante;
	}

	public ToEmail(String email, int id_anunciante) {
		super();
		this.email = email;
		this.id_anunciante = id_anunciante;
	}

	public ToEmail() {
		super();
	}

	@Override
	public String toString() {
		return "Email (" + id_email + ", " + email + ", " + id_anunciante + ")";
	}
    public String toJson() {
        return new Gson().toJson(this);
    }
}
