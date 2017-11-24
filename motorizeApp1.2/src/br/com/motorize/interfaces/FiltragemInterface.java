package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anuncio;
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
	 * @param endereco
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Estado BuscarEstado(long id_estado,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;


	/**
	 * 
	 * @param endereco
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Cidade BuscarCidade(long id_cidade,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

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
	List<Cidade> BuscarCidades(long id_estado,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorOrdemNatural(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	List<Anuncio> OrdenarVeiculosPorMenorValor(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorMaiorValor(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;


	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorMenorKilometragem(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorMaiorKilometragem(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorOrdemAlfabeticaAZ(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorOrdemAlfabeticaZA(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorMaisNovo(String tipo_veiculo, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Anuncio> OrdenarVeiculosPorMaisVelho(String tipo_veiculo, Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException;



}
