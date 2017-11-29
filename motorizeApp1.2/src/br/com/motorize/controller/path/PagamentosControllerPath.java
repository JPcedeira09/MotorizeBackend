package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.PagamentosDAO;
import br.com.motorize.model.Pagamento;
import br.com.motorize.utils.ConexaoUtil;

@Path("/pagamentos")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class PagamentosControllerPath {

	@POST
	@Path("/AdicionarPagamento")
	public Response AdicionarPagamento(Pagamento pagamento){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new PagamentosDAO().AdicionarPagamento(pagamento,connection);
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
	@Path("/UpdatePagamento")
		public Pagamento UpdatePagamento(Pagamento pagamento){
			try {
				Connection connection = ConexaoUtil.getConnection();
				return new PagamentosDAO().UpdatePagamento(pagamento,connection);
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
	@Path("/BuscarPagamento/{id_pagamento}")
			public Pagamento BuscarPagamento(@PathParam("id_pagamento")int id_pagamento){
				try {
					Connection connection = ConexaoUtil.getConnection();
					return new PagamentosDAO().BuscarPagamento(id_pagamento,connection);
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
