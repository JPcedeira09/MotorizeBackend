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

import br.com.motorize.DAO.AssinaturaDAO;
import br.com.motorize.model.Assinature;
import br.com.motorize.model.GenericResponse;
import br.com.motorize.utils.ConexaoUtil;

@Path("/assinatura")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class AssinaturaControllerPath {


	@POST
	@Path("/adicionarAssinatura")
	public Response AdicionarAssinatura(Assinature assinatura){
		try {
			Connection connection = ConexaoUtil.getConnection();
			new AssinaturaDAO().AdicionarAssinatura(assinatura,connection);
			GenericResponse generic = new GenericResponse(true, "iNFO: assinatura adicionada com sucesso", 201);
			return Response.status(200).entity(generic.toJson()).build();
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

	@DELETE
	@Path("/adicionarAssinatura/{id_pessoa}")
	public Response DeletarAssinatura(@PathParam("id_pessoa")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			new AssinaturaDAO().DeletarAssinatura(id_pessoa,connection);
			GenericResponse generic = new GenericResponse(true, "iNFO: assinatura deletada com sucesso", 200);
			return Response.status(200).entity(generic.toJson()).build();
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
	@Path("/buscarAssinatura/{id_pessoa}")
	public Response BuscarAssinatura(@PathParam("id_pessoa")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			Assinature assinatura =  new AssinaturaDAO().BuscarAssinatura(id_pessoa,connection);
			return Response.status(200).entity(assinatura.toJson()).build();
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

	@PUT
	@Path("/atualizarAssinatura")
	public Response AtualizarAssinatura(Assinature assinatura){
		try {
			Connection connection = ConexaoUtil.getConnection();
			Assinature assinature = new AssinaturaDAO().AtualizarAssinatura(assinatura,connection);
			return Response.status(200).entity(assinature.toJson()).build();
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
