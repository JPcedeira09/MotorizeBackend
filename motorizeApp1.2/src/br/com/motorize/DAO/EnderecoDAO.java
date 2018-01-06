package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.EnderecoInterface;
import br.com.motorize.model.Endereco;
import br.com.motorize.model.GenericResponse;

public class EnderecoDAO implements EnderecoInterface{

	/**
	 * 
	 * @param endereco
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public GenericResponse AdiconarEndereco(Endereco endereco, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call adicionar_endereco(?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, endereco.getid_pessoa_fk());
		statement.setInt(2, endereco.getid_cidade());
		statement.setString(3, endereco.getCep());
		statement.setString(4, endereco.getRua());
		statement.setString(5, endereco.getNumero());
		statement.setString(6, endereco.getComplemento());
		statement.executeQuery();
		GenericResponse response = new GenericResponse(true, "INFO: endereço foi criado com sucesso.", 200);
		return response;
	}

	/**
	 * 
	 * @param endereco
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Endereco UpdateEndereco(Endereco endereco, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call update_endereco(?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, endereco.getid_pessoa_fk());
		statement.setInt(2, endereco.getid_cidade());
		statement.setString(3, endereco.getCep());
		statement.setString(4, endereco.getRua());
		statement.setString(5, endereco.getNumero());
		statement.setString(6, endereco.getComplemento());
		statement.executeQuery();
		String sqlQuery2 = "call buscarEndereco(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery2);
		statement2.setInt(1, endereco.getid_pessoa_fk());
		ResultSet set = statement2.executeQuery();
		Endereco endereco_novo = new Endereco();

		while (set.next()) {
			endereco_novo.setId_endereco(set.getInt("id_endereco"));
			endereco_novo.setid_pessoa_fk(set.getInt("id_pessoa_fk"));
			endereco_novo.setid_cidade(set.getInt("id_cidade"));
			endereco_novo.setRua(set.getString("rua"));
			endereco_novo.setNumero(set.getString("numero"));
			endereco_novo.setComplemento(set.getString("complemento"));
			endereco_novo.setCep(set.getString("CEP"));
		}
		return endereco;
	}

	/**
	 * 
	 * @param id_pessoa_fk
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public GenericResponse DeletarEndereco(long id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call deletar_Endereco(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setLong(1, id_pessoa_fk);
		statement.executeQuery();
		GenericResponse response = new GenericResponse(true, "INFO:endereco foi deletado com sucesso", 200);
		return response;
	}
	
	/**
	 * 
	 * @param id_pessoa_fk
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Endereco BuscarEndereco(long id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscarEndereco(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setLong(1, id_pessoa_fk);
		ResultSet set = statement.executeQuery();
		Endereco endereco = new Endereco();
		while (set.next()) {
			endereco.setId_endereco(set.getInt("id_endereco"));
			endereco.setid_pessoa_fk(set.getInt("id_pessoa_fk"));
			endereco.setid_cidade(set.getInt("id_cidade"));
			endereco.setRua(set.getString("rua"));
			endereco.setNumero(set.getString("numero"));
			endereco.setComplemento(set.getString("complemento"));
			endereco.setCep(set.getString("CEP"));
		}
		return endereco;
	}

}
