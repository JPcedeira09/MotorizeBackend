package br.com.motorize.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Produto;

public interface ProdutoInterface {

	/**
	 * 
	 * @param produto
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response AdicionarProduto(Produto produto, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param id_produto
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Response DeletarProduto(int id_produto, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param id_produto
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Produto BuscarProduto(int id_produto, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param id_pessoa
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Produto> BuscarProdutos(int id_pessoa, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException;
	
	/**
	 * 
	 * @param produto
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Produto UpdateProduto(Produto produto, Connection connection)throws SQLExceptions, ClassNotFoundException, SQLException;
	
	
}
