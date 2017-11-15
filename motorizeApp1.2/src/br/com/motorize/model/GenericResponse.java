package br.com.motorize.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name = "GenericResponse")
public class GenericResponse {

	@XmlAttribute(name="status")
	private boolean status;
	
	@XmlAttribute(name="message")
	private String message;
	
	@XmlAttribute(name="errorCode")
	private String errorCode;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "GenericResponse [status=" + status + ", message=" + message + ", errorCode=" + errorCode + "]";
	}


    public String toJson() {
        return new Gson().toJson(this);
    }
}
