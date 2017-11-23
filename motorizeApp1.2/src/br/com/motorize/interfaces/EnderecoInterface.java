package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Endereco;
import br.com.motorize.model.GenericResponse;

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
	GenericResponse AdiconarEndereco(Endereco endereco, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

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
	GenericResponse DeletarEndereco(long id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_pessoa_fk
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Endereco BuscarEndereco(long id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

}
