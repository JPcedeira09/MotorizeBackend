package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.motorize.DAO.PagamentosDAO;
import br.com.motorize.model.Pagamento;
import br.com.motorize.utils.ConexaoUtil;

@Path("/pagamentos")
@Consumes("application/json")
@Produces("application/json")
public class PagamentosControllerPath {

	
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

		public Pagamento UpdatePagamento(Pagamento pagamento){
			try {
				Connection connection = ConexaoUtil.getConnection();
				return new PagamentosDAO().AdicionarPagamento(pagamento,connection);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

			public Pagamento BuscarPagamento(int id_pagamento){
				try {
					Connection connection = ConexaoUtil.getConnection();
					return new PagamentosDAO().AdicionarPagamento(pagamento,connection);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

}
