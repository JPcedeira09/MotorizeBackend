package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anuncio;

public abstract interface AnunciosInterface {

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdicionarAnuncio(Anuncio anuncio, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Anuncio BuscarAnuncioID(long id_anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> BuscarAnunciosID(long id_anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	
	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response DeletarAnuncio(long id_anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Anuncio UpdateAnuncio(Anuncio anuncio, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;



}
