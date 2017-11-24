package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.PagamentosInterface;
import br.com.motorize.model.Pagamento;

public class PagamentosDAO implements PagamentosInterface{

	@Override
	public Response AdicionarPagamento(Pagamento pagamento, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call adicionar_pagamentos(?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, pagamento.getId_status());
		statement.setInt(2, pagamento.getid_assinatura());
		statement.executeQuery(sqlQuery);
		return Response.status(200).entity("INFO: Pagamento foi cadastrado com sucesso.").build();
	}
	@Override
	public Pagamento UpdatePagamento(Pagamento pagamento, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call update_pagamento(?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, pagamento.getId_status());
		statement.setInt(2, pagamento.getid_assinatura());
		statement.executeQuery(sqlQuery);

		String sqlQuery2 = "call buscar_pagamento(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery2);
		statement2.setInt(1, pagamento.getid_assinatura());
		ResultSet set = statement2.executeQuery(sqlQuery2);
		
		Pagamento novo_status_P = new Pagamento();
		while (set.next()) {
			novo_status_P.setId_status(set.getInt("id_status"));
			novo_status_P.setid_assinatura(set.getInt("id_assinatura"));
		}
		return novo_status_P;
	}

	@Override
	public Pagamento BuscarPagamento(int id_pagamento, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_pagamento(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_pagamento);
		ResultSet set = statement.executeQuery(sqlQuery);
		Pagamento pagamento = new Pagamento();
		while (set.next()) {
			pagamento.setId_status(set.getInt("id_status"));
			pagamento.setid_assinatura(set.getInt("id_assinatura"));
		}
		return pagamento;
	}

}
