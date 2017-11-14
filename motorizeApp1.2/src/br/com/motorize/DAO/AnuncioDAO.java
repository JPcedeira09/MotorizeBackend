package br.com.motorize.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.AnunciosInterface;
import br.com.motorize.model.Anuncio;

public class AnuncioDAO implements AnunciosInterface{

	@Override
	public Response AdicionarAnuncio(Anuncio anuncio, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sqlQuery = "call adicionaAnuncio(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, anuncio.getId_carro_fk());
		statement.setInt(2, anuncio.getId_pessoa_fk());
		statement.setDouble(3, anuncio.getPreco());
		statement.setDate(4, anuncio.getData_postagem());
		statement.setDate(5, anuncio.getAno_compra());
		statement.setString(6, anuncio.getCor());
		statement.setString(7, anuncio.getOpcional());
		statement.setString(8, anuncio.getBlindagem());
		statement.setInt(9, anuncio.getKilometragem());
		statement.setInt(10, anuncio.getNumero_portas());
		statement.setString(11, anuncio.getTipo_necessidade());
		statement.setString(12, anuncio.getCodigo());
		statement.setBlob(13, (InputStream)anuncio.getImagem_1());
		statement.setBlob(14, (InputStream)anuncio.getImagem_2());
		statement.setBlob(15,(InputStream) anuncio.getImagem_3());
		statement.setBlob(16, (InputStream)anuncio.getImagem_4());

		statement.executeQuery();
		return Response.status(200).entity("Anuncio Feito com sucesso.").build();	}


	@Override
	public List<Anuncio> BuscarAnunciosID(int id_pessoa_fk, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sqlQuery = "call buscar_meus_carros(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_pessoa_fk);
		ResultSet set = statement.executeQuery();
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		while(set.next()){
			Anuncio anuncio = new Anuncio();
			anuncio.setId_produto(set.getInt("id_produto"));
			anuncio.setId_pessoa_fk(set.getInt("id_pessoa_fk"));
			anuncio.setPreco(set.getDouble("preco"));
			anuncio.setData_postagem(set.getDate("data_postagem"));
			anuncio.setAno_compra(set.getDate("ano_compra"));
			anuncio.setCor(set.getString("cor"));
			anuncio.setOpcional(set.getString("opcional"));
			anuncio.setBlindagem(set.getString("blindagem"));
			anuncio.setNumero_portas(set.getInt("numero_portas"));
			anuncio.setTipo_necessidade(set.getString("tipo_necessidade"));
			anuncio.setCodigo(set.getString("codigo"));
			anuncio.setKilometragem(set.getInt("kilometragem"));
			anuncio.setImagem_1(set.getBinaryStream("imagem_1"));
			anuncio.setImagem_2(set.getBinaryStream("imagem_2"));
			anuncio.setImagem_3(set.getBinaryStream("imagem_3"));
			anuncio.setImagem_4(set.getBinaryStream("imagem_4"));
			anuncio.setId_carro_fk(set.getInt("id_carro_fk"));
			anuncios.add(anuncio);
		}	
	     
	     
	     return anuncios ;
	}


	@Override
	/**
	 * @params id_produto
	 * @params connection
	 */
	public Anuncio BuscarAnuncioID(int id_produto, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sqlQuery = "call buscar_anuncio('"+id_produto+"')";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		//statement.setInt(1, id_produto);
		ResultSet set = statement.executeQuery(sqlQuery);
		
		Anuncio anuncio = new Anuncio();

		while(set.next()){
			anuncio.setId_produto(set.getInt("id_produto"));
			anuncio.setId_pessoa_fk(set.getInt("id_pessoa_fk"));
			anuncio.setPreco(set.getDouble("preco"));
			anuncio.setData_postagem(set.getDate("data_postagem"));
			anuncio.setAno_compra(set.getDate("ano_compra"));
			anuncio.setCor(set.getString("cor"));
			anuncio.setOpcional(set.getString("opcional"));
			anuncio.setBlindagem(set.getString("blindagem"));
			anuncio.setNumero_portas(set.getInt("numero_portas"));
			anuncio.setTipo_necessidade(set.getString("tipo_necessidade"));
			anuncio.setCodigo(set.getString("codigo"));
			anuncio.setKilometragem(set.getInt("kilometragem"));
			anuncio.setImagem_1(set.getBinaryStream("imagem_1"));
			anuncio.setImagem_2(set.getBinaryStream("imagem_2"));
			anuncio.setImagem_3(set.getBinaryStream("imagem_3"));
			anuncio.setImagem_4(set.getBinaryStream("imagem_4"));
			anuncio.setId_carro_fk(set.getInt("id_carro_fk"));
		}

		return anuncio ;
	}

	@Override
	public Response DeletarAnuncio(int id_anuncio, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sqlQuery = "call deletar_anuncio(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_anuncio);
		statement.execute(sqlQuery);

		return Response.status(200).entity("Anuncio deletado com sucesso.").build();}

	@Override
	public Anuncio UpdateAnuncio(Anuncio anuncio, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sql = "call update_anuncio(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, anuncio.getId_produto());
		statement.setInt(2, anuncio.getId_pessoa_fk());
		statement.setDouble(3, anuncio.getPreco());
		statement.setDate(4, anuncio.getData_postagem());
		statement.setDate(5, anuncio.getAno_compra());
		statement.setString(6, anuncio.getCor());
		statement.setString(7, anuncio.getOpcional());
		statement.setString(8, anuncio.getBlindagem());
		statement.setInt(9, anuncio.getKilometragem());
		statement.setInt(10, anuncio.getNumero_portas());
		statement.setString(11, anuncio.getTipo_necessidade());
		statement.setString(12, anuncio.getCodigo());
		statement.setBlob(13, anuncio.getImagem_1());
		statement.setBlob(14, anuncio.getImagem_2());
		statement.setBlob(15, anuncio.getImagem_3());
		statement.setBlob(16, anuncio.getImagem_4());
		statement.setInt(17, anuncio.getId_carro_fk());
		statement.executeUpdate();

		String sqlQuery = "call buscar_anuncio('"+anuncio.getId_produto()+"')";
		PreparedStatement statement2 = connection.prepareStatement(sqlQuery);
		statement.setInt(1, anuncio.getId_pessoa_fk());
		ResultSet set = statement2.executeQuery();

		Anuncio novo_anuncio = new Anuncio();
		while(set.next()){
			novo_anuncio.setId_produto(set.getInt("id_produto"));
			novo_anuncio.setId_pessoa_fk(set.getInt("id_pessoa_fk"));
			novo_anuncio.setPreco(set.getDouble("preco"));
			novo_anuncio.setData_postagem(set.getDate("data_postagem"));
			novo_anuncio.setAno_compra(set.getDate("ano_compra"));
			novo_anuncio.setCor(set.getString("cor"));
			novo_anuncio.setOpcional(set.getString("opcional"));
			novo_anuncio.setBlindagem(set.getString("blindagem"));
			novo_anuncio.setNumero_portas(set.getInt("numero_portas"));
			novo_anuncio.setTipo_necessidade(set.getString("tipo_necessidade"));
			novo_anuncio.setCodigo(set.getString("codigo"));
			novo_anuncio.setKilometragem(set.getInt("kilometragem"));
			novo_anuncio.setImagem_1(set.getBinaryStream("imagem_1"));
			novo_anuncio.setImagem_2(set.getBinaryStream("imagem_2"));
			novo_anuncio.setImagem_3(set.getBinaryStream("imagem_3"));
			novo_anuncio.setImagem_4(set.getBinaryStream("imagem_4"));
			novo_anuncio.setId_carro_fk(set.getInt("id_carro_fk"));
		}
		return novo_anuncio ;
	}

}
