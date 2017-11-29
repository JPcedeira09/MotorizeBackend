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
import br.com.motorize.utils.ConexaoUtil;

@Path("/assinatura")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class AssinaturaControllerPath {


	@POST
	@Path("/AdicionarAssinatura")
	public Response AdicionarAssinatura(Assinature assinatura){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new AssinaturaDAO().AdicionarAssinatura(assinatura,connection);
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
	@Path("/AdicionarAssinatura/{id_pessoa}")
	public Response DeletarAssinatura(@PathParam("id_pessoa")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new AssinaturaDAO().DeletarAssinatura(id_pessoa,connection);
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
	@Path("/BuscarAssinatura/{id_pessoa}")
	public Assinature BuscarAssinatura(@PathParam("id_pessoa")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new AssinaturaDAO().BuscarAssinatura(id_pessoa,connection);
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
	
	@PUT
	@Path("/AtualizarAssinatura")
		public Assinature AtualizarAssinatura(Assinature assinatura){
			try {
				Connection connection = ConexaoUtil.getConnection();
				return new AssinaturaDAO().AtualizarAssinatura(assinatura,connection);
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
