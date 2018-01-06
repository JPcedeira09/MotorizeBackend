package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

import br.com.motorize.DAO.AnuncioDAO;
import br.com.motorize.DAO.FiltragemDAO;
import br.com.motorize.model.Anuncio;
import br.com.motorize.model.GenericResponse;
import br.com.motorize.model.Veiculo;
import br.com.motorize.utils.ConexaoUtil;


@Path("/anuncios")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class AnuncioControllerParh {

	@POST
	@Path("/adicionarAnuncio")
	public Response AdicionarAnuncio(Anuncio anuncio) {
		Connection connection;
		try {
			connection = ConexaoUtil.getConnection();
			new AnuncioDAO().AdicionarAnuncio(anuncio, connection);
			return Response.status(200).entity(anuncio.toJson()).build();
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
	@Path("/updateAnuncio")
	public Response UpdateAnuncio(Anuncio anuncio) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			new AnuncioDAO().UpdateAnuncio(anuncio, connection);
			return Response.ok().build();
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
	@Path("/deletarAnuncio/{id}")
	public Response DeletarAnuncio(@PathParam("id") long id_anuncio) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			new AnuncioDAO().DeletarAnuncio(id_anuncio, connection);
			return Response.ok().build();
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
	@Path("/buscarAnuncio/{id}")
	public Response BuscarAnuncioID(@PathParam("id") long id) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anuncio anuncio = new AnuncioDAO().BuscarAnuncioID(id, connection);
			return Response.status(200).entity(anuncio.toJson()).build();
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
	@Path("/buscarAnuncios/{id}")
	public Response BuscarAnunciosID(@PathParam("id") long id_pessoa_fk) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Anuncio> anuncios = new AnuncioDAO().BuscarAnunciosID(id_pessoa_fk, connection);
			return Response.status(200).entity(anuncios).build();
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
	@Path("/buscarTipoVeiculo")
	public Response BuscarTipoVeiculo(Veiculo anuncio) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> anuncios = new FiltragemDAO().BuscarTipo_Veiculo(connection);
			return Response.status(200).entity(anuncios).build();
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
	@Path("/buscarMarcas")
	public Response BuscarMarcas( String tipo_veiculo) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> anuncios = new FiltragemDAO().BuscarMarcas(tipo_veiculo, connection);
			return Response.status(200).entity(anuncios).build();
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
	@Path("/buscarModelos")
	public Response BuscarModelos(Veiculo veiculo) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> anuncios = new FiltragemDAO().BuscarModelos(veiculo, connection);
			return Response.status(200).entity(anuncios).build();
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
	@Path("/buscarVersao")
	public Response BuscarVersao(Veiculo veiculo) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> 	anuncios = new FiltragemDAO().BuscarVersao(veiculo, connection);
			return Response.status(200).entity(anuncios).build();
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
