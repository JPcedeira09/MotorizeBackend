package br.com.motorize.exception;

import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebFault;

@WebFault(name = "MensagemException")
public class MensagemException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MensagemException(String Mensagem) {
      super();
}
	

}
