package br.com.motorize.interfaces;

import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Pagamento;

public abstract interface PagamentosInterface {

	/**
	 * 
	 * @param pagamento
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdicionarPagamento(Pagamento pagamento) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param pagamento
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Pagamento UpdatePagamento(Pagamento pagamento) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param pagamento
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Pagamento BuscarPagamento(int pagamento)throws SQLExceptions, ClassNotFoundException, SQLException;
}
