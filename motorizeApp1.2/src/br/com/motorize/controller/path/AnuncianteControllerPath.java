package br.com.motorize.controller.path;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.AnuncianteDAO;
import br.com.motorize.model.Anunciante;
import br.com.motorize.model.GenericResponse;
import br.com.motorize.utils.ConexaoUtil;

@Path("/anunciante")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class AnuncianteControllerPath {

	
	// curl -d "{"nome":"obey","CPF":"461.555.888-72","senha":"sennhaTG","telefone":"4252-3142","celular":"99555353","tipo_pessoa":"Fisica","status":"N"}" http://localhost:8088/motorizeApp1.2/motorize/anunciante/adicionarAnunciante
	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<h1>Hello World</h1>";
	}

	@POST
	@Path("/adicionarAnunciante")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response AdicionarAnunciante(Anunciante anunciante) throws URISyntaxException{
		try {
			Connection connection = ConexaoUtil.getConnection();
			String response = new AnuncianteDAO().AdicionarAnunciante(anunciante, connection);
			//URI uri = new URI("/anunciante/BuscarAnunciante/"+anunciante.getCPF());
			System.out.println(response);
			//created(uri).
			return Response.status(200).entity("INFO:adicionado com sucesso").build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(200).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(200).entity(generic.toJson()).build();
		}
	}

	@GET
	@Path("/buscarAnunciante/{CPF}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response BuscarAnunciante(@PathParam("CPF")String CPF){
		try {
			Connection connection = ConexaoUtil.getConnection();
			 Anunciante anunciante = new AnuncianteDAO().BuscarAnunciante(CPF, connection);
				return Response.status(200).entity(anunciante.toJson()).build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(200).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(200).entity(generic.toJson()).build();
		}
	}
	
	// http://localhost:8088/motorizeApp1.2/motorize/anunciante/adicionarAnunciante

	//{"cpf":"461.878.888-73","nome":"obey","CPF":"461.555.888-72","senha":"sennhaTG","ano_nascimento":"1966-09-09","telefone":"4252-3142","celular":"99555353","tipo_pessoa":"Fisica","status":"N"}
	
	@DELETE
	@Path("/deletarAnunciante/{id_pessoa}")
	public Response DeletarAnunciante(@PathParam("id_pessoa")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			String response = new AnuncianteDAO().DeletarAnunciante(id_pessoa, connection);
			return Response.status(200).entity(response).build();
		} catch (ClassNotFoundException e) {
			GenericResponse generic = new GenericResponse(false, "ClassNotFoundException", 404);
			e.printStackTrace();
			return Response.status(200).entity(generic.toJson()).build();
		} catch (SQLException e) {
			GenericResponse generic = new GenericResponse(false, "SQLException", 500);
			e.printStackTrace();
			return Response.status(200).entity(generic.toJson()).build();
		}
	}

}
