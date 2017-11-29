package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.AssinaturaInterface;
import br.com.motorize.model.Assinature;

public class AssinaturaDAO implements AssinaturaInterface{

	
	/**
	 * 
	 * @param assinatura
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Response AdicionarAssinatura(Assinature assinatura, Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call adicionar_assinatura(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, assinatura.getId_pessoa_fk());
		statement.setInt(2, assinatura.getId_tipoAssinatura());
		statement.setInt(3, assinatura.getid_status());
		statement.executeUpdate();
		return Response.status(200).entity("INFO: assinatura cadastrada com sucesso.").build();
	}

	/**
	 * 
	 * @param id_pessoa
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Response DeletarAssinatura(long id_pessoa, Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		
		String sqlQuery = "call deletar_assinatura(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setLong(1, id_pessoa);
		statement.executeQuery();
		
		return Response.status(200).entity("INFO: assinatura deletada com sucesso.").build();
	}

	/**
	 * 
	 * @param id_pessoa
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Assinature BuscarAssinatura(long id_pessoa, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_assinante(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setLong(1, id_pessoa);
		ResultSet set = statement.executeQuery();
		Assinature assinatura = new Assinature();
		while (set.next()) {
			assinatura.setId_assinatura(set.getInt("id_assinatura"));
			assinatura.setId_pessoa_fk(set.getInt("id_pessoa_fk"));
			assinatura.setId_tipoAssinatura(set.getInt("id_tipo_assinatura"));
			assinatura.setid_status(set.getInt("id_status"));
		}
		return assinatura;
	}

	/**
	 * 
	 * @param assinatura
	 * @param connection
	 * @return
	 * @throws SQLExceptions
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Assinature AtualizarAssinatura(Assinature assinatura, Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call update_assinatura (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, assinatura.getId_pessoa_fk());
		statement.setInt(2, assinatura.getId_tipoAssinatura());
		statement.setInt(3, assinatura.getid_status());
		statement.executeQuery();

		String sqlQuery2 = "call buscar_assinante(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery2);
		statement2.setInt(1, assinatura.getId_pessoa_fk());
		ResultSet set = statement2.executeQuery();
		Assinature assinatura_novo = new Assinature();
		while (set.next()) {
			assinatura_novo.setId_assinatura(set.getInt("id_assinatura"));
			assinatura_novo.setId_pessoa_fk(set.getInt("id_pessoa_fk"));
			assinatura_novo.setId_tipoAssinatura(set.getInt("id_tipo_assinatura"));
			assinatura_novo.setid_status(set.getInt("id_status"));
		}
		return assinatura_novo;
		
	}

}
