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

import br.com.motorize.DAO.ProdutoDAO;
import br.com.motorize.model.Produto;
import br.com.motorize.utils.ConexaoUtil;

@Path("/produtos")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class ProdutosControllerPath {

	@POST
	@Path("/AdicionarProduto")
	public Response AdicionarProduto(Produto produto){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ProdutoDAO().AdicionarProduto(produto,connection);
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
	@Path("/DeletarProduto/{id_produto}")
	public Response DeletarProduto(@PathParam("id_produto") int id_produto){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ProdutoDAO().DeletarProduto(id_produto,connection);
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
	@Path("/BuscarProduto/{id_produto}")
	public Produto BuscarProduto(@PathParam("id_produto") int id_produto){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ProdutoDAO().BuscarProduto(id_produto,connection);
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
	@Path("/BuscarProduto/{id_pessoa}")
	public List<Produto> BuscarProdutos(@PathParam("id_pessoa") int id_pessoa){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ProdutoDAO().BuscarProdutos(id_pessoa,connection);
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
	@Path("/UpdateProduto/{produto}")
	public Produto UpdateProduto(Produto produto){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new ProdutoDAO().UpdateProduto(produto,connection);
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
