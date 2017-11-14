package br.com.motorize.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "NotificationException")
public class NotificationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotificationException(String menssagem) {
		super(menssagem);
	}
	
}
