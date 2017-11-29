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

import br.com.motorize.DAO.ServicoDAO;
import br.com.motorize.model.Servico;
import br.com.motorize.utils.ConexaoUtil;

@Path("/servicos")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class ServicosControllerPath {

	@POST
	@Path("/AdicionarServico")
	public Response AdicionarServico(Servico servico){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ServicoDAO().AdicionarServico(servico,connection);
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
	@Path("/DeletarServico/{id_servico}")
	public Response DeletarServico(@PathParam("id_servico")long id_servico){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ServicoDAO().DeletarServico(id_servico,connection);
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
	@Path("/BuscarServico/{id_servico}")
	public Servico BuscarServico(@PathParam("id_servico")long id_servico){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ServicoDAO().BuscarServico(id_servico,connection);
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
	@Path("/BuscarServicos/{id_servico}")
	public List<Servico> BuscarServicos(@PathParam("id_servico")long id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ServicoDAO().BuscarServicos(id_pessoa,connection);
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
	@Path("/UpdateServico")
	public Servico UpdateServico(Servico servico){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ServicoDAO().UpdateServico(servico,connection);
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
