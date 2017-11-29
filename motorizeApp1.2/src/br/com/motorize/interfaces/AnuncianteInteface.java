package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anunciante;

public abstract interface AnuncianteInteface {

	
	String AdicionarAnunciante(Anunciante anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	Anunciante BuscarAnunciante(String CPF, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	String DeletarAnunciante(long id_anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	Anunciante UpdateAnunciante(Anunciante anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;




}
