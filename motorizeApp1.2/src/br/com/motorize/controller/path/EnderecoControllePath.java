package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.EnderecoDAO;
import br.com.motorize.model.Endereco;
import br.com.motorize.model.GenericResponse;
import br.com.motorize.utils.ConexaoUtil;

@Path("/endereco")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class EnderecoControllePath {

	@POST
	@Path("/adiconarEndereco")
	public Response AdiconarEndereco(Endereco endereco) {
		Connection connection;
		try {
			connection = ConexaoUtil.getConnection();
			GenericResponse response = new EnderecoDAO().AdiconarEndereco(endereco, connection);
			return Response.status(200).entity(response.toJson()).build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		}
	}

	@PUT
	@Path("/UpdateEndereco")
	public Response UpdateEndereco(Endereco endereco){
		try {
			Connection connection = ConexaoUtil.getConnection();
			Endereco retorno = new EnderecoDAO().UpdateEndereco(endereco, connection);
			return Response.status(200).entity(retorno.toJson()).build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		}
	}

	@DELETE
	@Path("/DeletarEndereco/{id_pessoa_fk}")
	public Response DeletarEndereco(@PathParam("id_pessoa_fk") long id_pessoa_fk)  {
		try {
			Connection connection = ConexaoUtil.getConnection();
			GenericResponse response = new EnderecoDAO().DeletarEndereco(id_pessoa_fk, connection);
			return Response.status(204).entity(response.toJson()).build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		}
	}

	@GET
	@Path("/BuscarEndereco/{id_pessoa_fk}")
	public Response BuscarEndereco(@PathParam("id_pessoa_fk") long id_pessoa_fk)  {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Endereco retorno = new EnderecoDAO().BuscarEndereco(id_pessoa_fk, connection);
			return Response.status(200).entity(retorno.toJson()).build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(500).entity(generic.toJson()).build();
		}
	}

}
