package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Assinature;

public abstract interface AssinaturaInterface {

	/**
	 * 
	 * @param assinatura
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdicionarAssinatura(Assinature assinatura, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param id_pessoa
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Assinature BuscarAssinatura(long id_pessoa, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param assinatura
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Assinature AtualizarAssinatura(Assinature assinatura, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_pessoa
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response DeletarAssinatura(long id_pessoa, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
}
