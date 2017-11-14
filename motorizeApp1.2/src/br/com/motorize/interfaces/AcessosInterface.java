package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anunciante;

public abstract interface AcessosInterface {

	/**
	 * @author JohnnyCedeira 
	 * Procedure login_base MYSQL
	 * @param CPF
	 * @param senha
	 * @return Anunciante
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Anunciante Login(String CPF, String senha, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	
	/**
	 * Procedure login_anunciante
	 * @param CPF
	 * @param senha
	 * @return 
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Anunciante Acesso(String CPF, String senha, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	
	/**
	 * Procedure upadate_status_service_N  atualiza status Service para N 
	 * @param anunciante
	 * @return Anunciante
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Anunciante Logout(String CPF, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;









	
}
