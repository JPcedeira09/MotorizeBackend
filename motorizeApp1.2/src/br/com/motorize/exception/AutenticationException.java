package br.com.motorize.exception;

import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebFault;

@WebFault(name = "AutenticationException")
public class AutenticationException extends WebApplicationException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  AutenticationException(String menssagem) {
		super(menssagem);
	}
	
}
