package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;

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
public class AcessoControllePath {

	@GET
	@Path("/logar/{CPF}/{senha}")
	private Response fullAccess(@PathParam("CPF") String CPF, @PathParam("senha") String senha)  {
		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AcessoDAO().Acesso(CPF, senha, connection);
			return Response.status(200).entity(anunciante.toJson()).build();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/login/{CPF}/{senha}")
	private Anunciante logar(@PathParam("CPF") String CPF, @PathParam("senha") String senha) {

		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AcessoDAO().Login(CPF, senha, connection);
			return anunciante;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@GET
	@Path("/logout")
	private Anunciante logout(String CPF) {

		try {
			Connection connection = ConexaoUtil.getConnection();
			Anunciante anunciante = new AcessoDAO().Logout(CPF , connection);
			return anunciante;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
