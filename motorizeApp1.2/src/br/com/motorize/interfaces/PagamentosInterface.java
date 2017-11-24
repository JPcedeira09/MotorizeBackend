package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Pagamento;

public abstract interface PagamentosInterface {

	/**
	 * 
	 * @param pagamento
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdicionarPagamento(Pagamento pagamento, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param pagamento
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Pagamento UpdatePagamento(Pagamento pagamento, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param pagamento
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Pagamento BuscarPagamento(int pagamento, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;
}
