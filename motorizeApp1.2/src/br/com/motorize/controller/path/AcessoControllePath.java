package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.AcessoDAO;
import br.com.motorize.model.Anunciante;
import br.com.motorize.utils.ConexaoUtil;

@Path("/acesso")
@Produces("application/json")
@Consumes("application/json")
@Singleton
public class AcessoControllePath {

	@GET
	@Path("/teste")
	public Response teste()  {
	return Response.status(200).entity("Servidor Online").build();
	}
	
	@GET
	@Path("/Acesso/{CPF}/{senha}")
	public Response Acesso(@PathParam("CPF") String CPF, @PathParam("senha") String senha)  {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AcessoDAO().Acesso(CPF, senha, connection);
			System.out.println("Usuario longando");
			System.out.println(anunciante.toJson());
			return Response.status(200).entity(anunciante.toJson()).build();
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
	@Path("/Login/{CPF}/{senha}")
	public Anunciante Login(@PathParam("CPF") String CPF, @PathParam("senha") String senha) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AcessoDAO().Login(CPF, senha, connection);
			return anunciante;
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
	@Path("/Logou/{CPF}")
	public Anunciante Logout(@PathParam("CPF")String CPF) {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AcessoDAO().Logout(CPF , connection);
			return anunciante;
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
