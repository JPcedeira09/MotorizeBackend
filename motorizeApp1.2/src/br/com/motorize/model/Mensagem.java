package br.com.motorize.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "Mensagem")
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "title")
	private String title;

	@XmlAttribute(name = "msg")
	private String msg;

	@XmlAttribute(name = "cel")
	private String cel;

	@XmlAttribute(name = "id_user")
	private int id_user;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Mensagem [title=" + title + ", msg=" + msg + ", cel=" + cel + ", id_user=" + id_user + "]";
	}

	public Mensagem(String title, String msg, String cel, int id_user) {
		super();
		this.title = title;
		this.msg = msg;
		this.cel = cel;
		this.id_user = id_user;
	}

	public Mensagem() {
		super();
	}
    public String toJson() {
        return new Gson().toJson(this);
    }
}
