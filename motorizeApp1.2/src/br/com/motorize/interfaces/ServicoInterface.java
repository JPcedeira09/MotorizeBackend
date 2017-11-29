package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Servico;

public interface ServicoInterface {

	/**
	 * 
	 * @param servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdicionarServico(Servico servico, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response DeletarServico(long id_servico, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Servico BuscarServico(long id_servico, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param id_pessoa
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Servico> BuscarServicos(long id_pessoa, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Servico UpdateServico(Servico servico, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;

}
