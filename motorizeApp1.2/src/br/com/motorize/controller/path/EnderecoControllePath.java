package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.motorize.DAO.FiltragemDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Endereco;
import br.com.motorize.model.Estado;
import br.com.motorize.utils.ConexaoUtil;

@Path("/endereco")
@Consumes("application/json")
@Produces("application/json")
public class EnderecoControllePath {

	public String AdicionarEndereco(Endereco endereco) throws SQLExceptions, ClassNotFoundException, SQLException {

		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery2 = "insert into endereco (id_anunciante ,id_cidade ,CEP ,rua ,numero ,complemento) values (?,?,?,?,?,?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery2);
		statement2.setInt(1, endereco.getid_pessoa_fk());
		statement2.setInt(2, endereco.getid_cidade());
		statement2.setString(3, endereco.getCep());
		statement2.setString(4, endereco.getRua());
		statement2.setString(5, endereco.getNumero());
		statement2.setString(6, endereco.getComplemento());
		statement2.executeUpdate();
		statement2.close();
		return new String("INFO: endereco criado com sucesso.");
	}

	@GET
	@Path("/listarEstados")
	public List<Estado> GetEstados() {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Estado> estados = new FiltragemDAO().BuscarEstados(connection);
			return estados;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/getEstados/{id}")
	public Estado GetEstado(@PathParam("id") String id) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			int id_parse = Integer.parseInt(id);
			Estado estado = new FiltragemDAO().BuscarEstado(id_parse, connection);
			return estado;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/getCidades/{id}")
	public List<Cidade> GetCidades(@PathParam("id") String id) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			int id_estado = Integer.parseInt(id);
			List<Cidade> cidades = new FiltragemDAO().BuscarCidades(id_estado, connection);
			return cidades;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/GetCidade/{id}")
	public Cidade GetCidade(@PathParam("id") String id) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			int id_cidade = Integer.parseInt(id);
			Cidade cidade = new FiltragemDAO().BuscarCidade(id_cidade, connection);
			return cidade;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
