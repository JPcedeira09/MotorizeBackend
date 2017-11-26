package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.ServicoDAO;
import br.com.motorize.model.Servico;
import br.com.motorize.utils.ConexaoUtil;

@Path("/servicos")
@Consumes("application/json")
@Produces("application/json")
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


}
