package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
import br.com.motorize.model.Veiculo;
import br.com.motorize.utils.ConexaoUtil;


@Path("/carros")
@Consumes("application/json")
@Produces("application/json")
public class AnuncioControllerParh {

	@POST
	@Path("/AdicionarAnuncio")
	public Response AdicionarAnuncio(Anuncio anuncio) {
		Connection connection;
		try {
			connection = ConexaoUtil.getConnection();
			new AnuncioDAO().AdicionarAnuncio(anuncio, connection);
			return Response.status(200).entity(anuncio.toJson()).build();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@PUT
	@Path("/UpdateAnuncio")
	public Response UpdateAnuncio(Anuncio anuncio) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			new AnuncioDAO().UpdateAnuncio(anuncio, connection);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@DELETE
	@Path("/DeletarAnuncio/{id}")
	public Response DeletarAnuncio(@PathParam("id") long id_anuncio) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			new AnuncioDAO().DeletarAnuncio(id_anuncio, connection);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/BuscarAnuncio/{id}")
	public Anuncio BuscarAnuncioID(@PathParam("id") long id) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anuncio anuncio = new AnuncioDAO().BuscarAnuncioID(id, connection);
			return anuncio;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/BuscarAnuncios/{id}")
	public List<Anuncio> BuscarAnunciosID(@PathParam("id") long id_pessoa_fk) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Anuncio> anuncios = new AnuncioDAO().BuscarAnunciosID(id_pessoa_fk, connection);
			return anuncios;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/BuscarTipoVeiculo")
	public List<Veiculo> BuscarTipoVeiculo(Veiculo anuncio) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> anuncios = new FiltragemDAO().BuscarTipo_Veiculo(connection);
			return anuncios;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/BuscarMarcas")
	public List<Veiculo> BuscarMarcas( String tipo_veiculo) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> anuncios = new FiltragemDAO().BuscarMarcas(tipo_veiculo, connection);
			return anuncios;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET	
	@Path("/BuscarModelos")
	public List<Veiculo> BuscarModelos(Veiculo veiculo) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> anuncios = new FiltragemDAO().BuscarModelos(veiculo, connection);
			return anuncios;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/BuscarVersao")
	public List<Veiculo> BuscarVersao(Veiculo veiculo) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			List<Veiculo> 	anuncios = new FiltragemDAO().BuscarVersao(veiculo, connection);
			return anuncios;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
}
