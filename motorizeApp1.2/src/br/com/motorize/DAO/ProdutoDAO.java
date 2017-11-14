package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.ProdutoInterface;
import br.com.motorize.model.Produto;
import br.com.motorize.utils.ConexaoUtil;

public class ProdutoDAO implements ProdutoInterface{

	@Override
	public Response AdicionarProduto(Produto produto) throws SQLExceptions, ClassNotFoundException, SQLException {

		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery = "call adicionarProduto(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, produto.getId_pessoa_prest_fk());
		statement.setString(2, produto.getNome());
		statement.setString(3, produto.getCodigo());
		statement.setString(4, produto.getDescricao());
		statement.setDouble(5, produto.getPreco());
		statement.setInt(6, produto.getEntrega());
		statement.setInt(7, produto.getQuantidade());
		statement.setInt(8, produto.getDisponibilidade());
		statement.setString(9, produto.getTipo_produto());
		statement.setString(10, produto.getMarca());

		statement.execute(sqlQuery);
		statement.close();

		connection.commit();

		return Response.status(200).entity("INFO: Produto cadastrado com sucesso.").build();
	}

	@Override
	public Response DeletarProduto(int id_produto) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();

		String sqlQuery = "call deletarProduto(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_produto);
		statement.execute(sqlQuery);

		return Response.status(200).entity("INFO: Produto deletado com sucesso.").build();
	}

	@Override
	public Produto BuscarProduto(int id_produto) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery = "call buscarProduto(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_produto);
		ResultSet set = statement.executeQuery(sqlQuery);
		Produto produto = new Produto();

		while(set.next()){
			produto.setId_produto(set.getInt("id_produto"));
			produto.setId_pessoa_prest_fk(set.getInt("id_pessoa_prest_fk"));
			produto.setNome(set.getString("nome"));
			produto.setCodigo(set.getString("codigo"));
			produto.setDescricao(set.getString("descricao"));
			produto.setPreco(set.getDouble("preco"));
			produto.setEntrega(set.getInt("entrega"));
			produto.setQuantidade(set.getInt("quantidade"));
			produto.setDisponibilidade(set.getInt("disponibilidade"));
			produto.setTipo_produto(set.getString("tipo_produto"));
			produto.setMarca(set.getString("marca"));
		}
		return produto ;
	}


	@Override
	public List<Produto> BuscarProdutos(int id_pessoa) throws SQLExceptions, ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sqlQuery = "call buscarProdutos(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_pessoa);
		ResultSet set = statement.executeQuery(sqlQuery);
		List<Produto> produtos = new ArrayList<Produto>();

		while(set.next()){
			Produto produto = new Produto();
			produto.setId_produto(set.getInt("id_produto"));
			produto.setId_pessoa_prest_fk(set.getInt("id_pessoa_prest_fk"));
			produto.setNome(set.getString("nome"));
			produto.setCodigo(set.getString("codigo"));
			produto.setDescricao(set.getString("descricao"));
			produto.setPreco(set.getDouble("preco"));
			produto.setEntrega(set.getInt("entrega"));
			produto.setQuantidade(set.getInt("quantidade"));
			produto.setDisponibilidade(set.getInt("disponibilidade"));
			produto.setTipo_produto(set.getString("tipo_produto"));
			produto.setMarca(set.getString("marca"));
			produtos.add(produto);
		}
		return produtos ;
	}
	@Override
	public Produto UpdateProduto(Produto produto) throws SQLExceptions, ClassNotFoundException, SQLException {

		Connection connection = ConexaoUtil.getConnection();
		String sql = "call updateProduto(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, produto.getId_pessoa_prest_fk());
		statement.setString(2, produto.getNome());
		statement.setString(3, produto.getCodigo());
		statement.setString(4, produto.getDescricao());
		statement.setDouble(5, produto.getPreco());
		statement.setInt(6, produto.getEntrega());
		statement.setInt(7, produto.getQuantidade());
		statement.setInt(8, produto.getDisponibilidade());
		statement.setString(9, produto.getTipo_produto());
		statement.setString(10, produto.getMarca());
		statement.executeQuery(sql);

		String sqlQuery = "call buscarProduto(?)";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery);
		statement2.setInt(1, produto.getId_produto());
		ResultSet set = statement2.executeQuery(sqlQuery);
		Produto novo_produto = new Produto();

		while(set.next()){
			novo_produto.setId_produto(set.getInt("id_produto"));
			novo_produto.setId_pessoa_prest_fk(set.getInt("id_pessoa_prest_fk"));
			novo_produto.setNome(set.getString("nome"));
			novo_produto.setCodigo(set.getString("codigo"));
			novo_produto.setDescricao(set.getString("descricao"));
			novo_produto.setPreco(set.getDouble("preco"));
			novo_produto.setEntrega(set.getInt("entrega"));
			novo_produto.setQuantidade(set.getInt("quantidade"));
			novo_produto.setDisponibilidade(set.getInt("disponibilidade"));
			novo_produto.setTipo_produto(set.getString("tipo_produto"));
			novo_produto.setMarca(set.getString("marca"));
		}
		return novo_produto ;
	}

}
