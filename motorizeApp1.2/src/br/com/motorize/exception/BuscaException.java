package br.com.motorize.exception;

import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebFault;

@WebFault(name="BuscaException")
public class BuscaException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscaException(String mensagem) {
		super();
	}

}
