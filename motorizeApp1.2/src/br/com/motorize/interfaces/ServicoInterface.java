package br.com.motorize.interfaces;

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
	Response AdicionarServico(Servico servico)throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response DeletarServio(int id_servico)throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Servico BuscarServico(int id_servico)throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param id_pessoa
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Servico> BuscarServicos(int id_pessoa) throws SQLExceptions, ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param servico
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Servico UpdateServico(Servico servico)throws SQLExceptions, ClassNotFoundException, SQLException;

}
