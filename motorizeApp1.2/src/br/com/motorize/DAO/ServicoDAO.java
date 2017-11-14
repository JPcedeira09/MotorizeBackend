package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.ServicoInterface;
import br.com.motorize.model.Servico;
import br.com.motorize.utils.ConexaoUtil;

public class ServicoDAO implements ServicoInterface{

	@Override
	public Response AdicionarServico(Servico servico) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery = "call adicionarServico(?,)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, servico.getId_pessoa_prest_fk());
		statement.setString(2, servico.getNome_servico());
		statement.setDouble(3, servico.getValor_servico());
		statement.setString(4, servico.getTipo_servico());
		statement.setTime(5, servico.getTempo_estimado());
		statement.setInt(6, servico.getAberto());
		statement.setTime(7, servico.getAbertura());
		statement.setTime(8, servico.getFechamento());
		statement.setString(9, servico.getDescricao());
		statement.setString(10, servico.getDiferencial());
		statement.setString(11, servico.getCodigo());

		statement.execute(sqlQuery);
		connection.commit();
		statement.close();

		return Response.status(200).entity("INFO: Servico cadastrado com sucesso.").build();
	}

	@Override
	public Response DeletarServio(int id_servico) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();

		String sqlQuery = "call deletarServico(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_servico);
		statement.execute(sqlQuery);
		return Response.status(200).entity("INFO: Servico deletado com sucesso.").build();

	}

	@Override
	public Servico BuscarServico(int id_servico) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery = "call buscarServiço(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery);
		statement2.setInt(1, id_servico);
		ResultSet set = statement2.executeQuery(sqlQuery);
		Servico servico = new Servico();

		while(set.next()){
			servico.setId_serviço(set.getInt("id_serviço"));
			servico.setId_pessoa_prest_fk(set.getInt("id_pessoa_prest_fk"));
			servico.setNome_servico(set.getString("nome_servico"));
			servico.setValor_servico(set.getDouble("valor_servico"));
			servico.setTipo_servico(set.getString("tipo_servico"));
			servico.setTempo_estimado(set.getTime("tempo_estimado"));
			servico.setAberto(set.getInt("aberto"));
			servico.setAbertura(set.getTime("abertura"));
			servico.setFechamento(set.getTime("fechamento"));
			servico.setDescricao(set.getString("descricao"));
			servico.setDiferencial(set.getString("diferencial"));
			servico.setCodigo(set.getString("codigo"));
		}
		return servico ;

	}
	@Override
	public List<Servico> BuscarServicos(int id_pessoa) throws SQLExceptions, ClassNotFoundException, SQLException {
		
		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery = "call buscarServicos(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery);
		statement2.setInt(1, id_pessoa);
		ResultSet set = statement2.executeQuery(sqlQuery);
		List<Servico> servicos = new ArrayList<Servico>();

		while(set.next()){
			Servico servico = new Servico();
			servico.setId_serviço(set.getInt("id_serviço"));
			servico.setId_pessoa_prest_fk(set.getInt("id_pessoa_prest_fk"));
			servico.setNome_servico(set.getString("nome_servico"));
			servico.setValor_servico(set.getDouble("valor_servico"));
			servico.setTipo_servico(set.getString("tipo_servico"));
			servico.setTempo_estimado(set.getTime("tempo_estimado"));
			servico.setAberto(set.getInt("aberto"));
			servico.setAbertura(set.getTime("abertura"));
			servico.setFechamento(set.getTime("fechamento"));
			servico.setDescricao(set.getString("descricao"));
			servico.setDiferencial(set.getString("diferencial"));
			servico.setCodigo(set.getString("codigo"));
			servicos.add(servico);
		}
		return servicos ;
	}
	@Override
	public Servico UpdateServico(Servico servico) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sql = "call updateProduto(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, servico.getId_serviço());
		statement.setInt(2, servico.getId_pessoa_prest_fk());
		statement.setString(3, servico.getNome_servico());
		statement.setDouble(4, servico.getValor_servico());
		statement.setString(5, servico.getTipo_servico());
		statement.setTime(7, servico.getTempo_estimado());
		statement.setInt(8, servico.getAberto());
		statement.setTime(9,servico.getAbertura());
		statement.setTime(10, servico.getFechamento());
		statement.setString(11, servico.getDiferencial());
		statement.setString(11, servico.getCodigo());

		statement.executeQuery(sql);

		String sqlQuery = "call buscarServiço(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery);
		statement2.setInt(1, servico.getId_serviço());
		ResultSet set = statement2.executeQuery(sqlQuery);
		Servico novo_servico = new Servico();

		while(set.next()){
			novo_servico.setId_serviço(set.getInt("id_serviço"));
			novo_servico.setId_pessoa_prest_fk(set.getInt("id_pessoa_prest_fk"));
			novo_servico.setNome_servico(set.getString("nome_servico"));
			novo_servico.setValor_servico(set.getDouble("valor_servico"));
			novo_servico.setTipo_servico(set.getString("tipo_servico"));
			novo_servico.setTempo_estimado(set.getTime("tempo_estimado"));
			novo_servico.setAberto(set.getInt("aberto"));
			novo_servico.setAbertura(set.getTime("abertura"));
			novo_servico.setFechamento(set.getTime("fechamento"));
			novo_servico.setDescricao(set.getString("descricao"));
			novo_servico.setDiferencial(set.getString("diferencial"));
			novo_servico.setCodigo(set.getString("codigo"));
		}
		return novo_servico ;

	}

}
