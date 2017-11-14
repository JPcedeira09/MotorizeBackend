package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Estado;
import br.com.motorize.model.Veiculo;

public abstract interface FiltragemInterface {


	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> BuscarMarcas(String tipo_veiculo,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> BuscarTipo_Veiculo(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> BuscarModelos(Veiculo veiculo,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param anuncio
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> BuscarVersao(Veiculo veiculo,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> OrdenarVeiculosPorX(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	List<Veiculo> OrdenarVeiculosPorY(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> OrdenarVeiculosPorZ(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Veiculo> OrdenarVeiculosPorW(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	
	/**
	 * 
	 * @param endereco
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Estado BuscarEstado(int id_estado,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;


	/**
	 * 
	 * @param endereco
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Cidade BuscarCidade(int id_cidade,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param endereco
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Estado> BuscarEstados(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param endereco
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Cidade> BuscarCidades(int id_estado,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;



}
