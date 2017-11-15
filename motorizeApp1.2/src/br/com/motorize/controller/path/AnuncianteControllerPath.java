package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.AnuncianteDAO;
import br.com.motorize.model.Anunciante;
import br.com.motorize.model.GenericResponse;
import br.com.motorize.utils.ConexaoUtil;

@Path("/anunciante")
@Consumes("application/json")
@Produces("application/json")
public class AnuncianteControllerPath {

	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<h1>Hello World</h1>";
	}

	private Anunciante validarAnuncianteExistente(long id) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sql = "call buscar_anunciante (?)";
		PreparedStatement statement2 = connection.prepareStatement(sql);
		statement2.setLong(1, id);
		ResultSet set = statement2.executeQuery();
		Anunciante anunciante = new Anunciante();
		if (set.next()) {
			anunciante.setid_pessoa(set.getInt("id_pessoa"));
			anunciante.setNome(set.getString("nome"));
			anunciante.setCPF(set.getString("CPF"));
			anunciante.setSenha(set.getString("senha"));
			anunciante.setCelular(set.getString("celular"));
			anunciante.setTelefone(set.getString("telefone"));
			anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
			anunciante.setStatus(set.getString("Astatus"));
			anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
		}
		return anunciante;
	}

	@POST
	@Path("/add")
	public Response AdicionarAnunciante(Anunciante anunciante) {
		GenericResponse response = new GenericResponse();
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante valid =  validarAnuncianteExistente(anunciante.getid_pessoa());
			if(valid == null || valid.getNome() == "" || valid.getNome() == null){
				response.setStatus(false);
				response.setMessage("INFO:Erro ao adicionar anunciante no servidor.");
				response.setErrorCode("INFO:ERROR");
				return Response.status(404).entity(response).build();
			}
			Response resposta = new AnuncianteDAO().AdicionarAnunciante(anunciante, connection);
			response.setStatus(true);
			response.setMessage(resposta.toString());
			return Response.ok(response).build();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{id}")
	public Anunciante buscaAnunciantePorID(@PathParam("id") String CPF) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AnuncianteDAO().BuscarAnunciante(CPF, connection);
			return anunciante;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@DELETE
	@Path("/delete/{id}")
	public Response DeletarAnunciante(@PathParam("id") long id) {
		GenericResponse response = new GenericResponse();
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante valid =  validarAnuncianteExistente(id);
			if(valid == null || valid.getNome() == "" || valid.getNome() == null){
				response.setStatus(false);
				response.setMessage("INFO: Anunciante ja está cadastrado. ");
				response.setErrorCode("Erro add anunciante");
				return Response.status(404).entity(response).build();
			}
			Response resposta = new AnuncianteDAO().DeletarAnunciante(id, connection);
			response.setStatus(true);
			response.setMessage(resposta.toString());
			return Response.ok(response).build();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Path("/atualizar")
	public Anunciante AtualizarAnunciante(Anunciante anunciante) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante valid =  validarAnuncianteExistente(anunciante.getid_pessoa());
			if(valid == null || valid.getNome() == "" || valid.getNome() == null){
				return null;
			}
			return  new AnuncianteDAO().UpdateAnunciante(anunciante, connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;		
			}
	}
}
