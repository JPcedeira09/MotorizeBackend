package br.com.motorize.controller.path;

import java.net.URI;
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
import br.com.motorize.utils.ConexaoUtil;

@Path("/anunciante")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class AnuncianteControllerPath {

	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<h1>Hello World</h1>";
	}

	@POST
	@Path("/adicionarAnunciante")
	public Response AdicionarAnunciante(Anunciante anunciante) throws URISyntaxException{
		try {
			Connection connection = ConexaoUtil.getConnection();
			String response = new AnuncianteDAO().AdicionarAnunciante(anunciante, connection);
			URI uri = new URI("/anunciante/BuscarAnunciante/"+anunciante.getCPF());
			System.out.println(response);
			return Response.created(uri).status(200).entity(anunciante).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}

	@GET
	@Path("/buscarAnunciante/{CPF}")
	public Anunciante BuscarAnunciante(@PathParam("CPF")String CPF){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new AnuncianteDAO().BuscarAnunciante(CPF, connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

	@DELETE
	@Path("/deletarAnunciante/{id_pessoa}")
	public Response DeletarAnunciante(@PathParam("id_pessoa")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			String response = new AnuncianteDAO().DeletarAnunciante(id_pessoa, connection);
			return Response.status(200).entity(response).build();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}

}
