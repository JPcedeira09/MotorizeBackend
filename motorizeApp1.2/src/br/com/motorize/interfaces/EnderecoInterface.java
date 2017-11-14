package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Endereco;

public interface EnderecoInterface {

	/**
	 * 
	 * @param endereco
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdiconarEndereco(Endereco endereco, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param endereco
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Endereco UpdateEndereco(Endereco endereco, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_pessoa_fk
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response DeletarEndereco(int id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_pessoa_fk
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Endereco BuscarEndereco(int id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

}
