package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.AnuncianteInteface;
import br.com.motorize.model.Anunciante;

public class AnuncianteDAO implements AnuncianteInteface{

	Connection connection ;

/*	{"nome":"obey",
		"CPF":"461.555.888-72",
		"senha":"sennhaTG",
		"telefone":"4252-3142",
		"celular":"99555353",
		"tipo_pessoa":"Fisica",
		"status":"N"}*/
	@Override
	public String AdicionarAnunciante(Anunciante anunciante, Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call adicionar_anunciante(?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, anunciante.getNome());
		statement.setString(2, anunciante.getCPF());
		statement.setString(3, anunciante.getSenha());
		//statement.setString(4, anunciante.getAno_nascimento());
		statement.setString(4, anunciante.getTelefone());
		statement.setString(5, anunciante.getCelular());
		statement.setString(6, anunciante.getTipo_pessoa());
		statement.setString(7, anunciante.getStatus());
		statement.executeUpdate();
		return 	new String("INFO:anunciante cadastrado com sucesso.");
	}	

	@Override
	public Anunciante BuscarAnunciante(String CPF, Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		Anunciante anunciante = new Anunciante();
		try {
			//TODO arrumar no banco o buscar_assinante e trocar ID_PESSOA pro CPF;29-11-2017
			String sql = "call buscar_anunciante('"+CPF+"')";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				anunciante = new Anunciante();
				anunciante.setNome(set.getString("nome"));
				anunciante.setCPF(set.getString("CPF"));
				anunciante.setSenha(set.getString("senha"));
				//anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
				anunciante.setTelefone(set.getString("telefone"));
				anunciante.setCelular(set.getString("celular"));
				anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
				anunciante.setid_pessoa(set.getInt("id_pessoa"));
				anunciante.setStatus(set.getString("Astatus"));
			}
			return anunciante;
		} catch (SQLException e) {
			System.out.println("INFO: Problemas na busca do usuario...");
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public String DeletarAnunciante(long id_pessoa, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String Query = "call deletar_anunciante(?)";
		PreparedStatement statement = connection.prepareStatement(Query);
		statement.setLong(1, id_pessoa);
		statement.executeQuery();
		return 	new String("Anunciante deletado com sucesso.");
	}

	@Override
	public Anunciante UpdateAnunciante(Anunciante anunciante, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sql = "call update_anunciante(?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, anunciante.getNome());
		statement.setString(2, anunciante.getCPF());
		statement.setString(3, anunciante.getSenha());
		statement.setDate(4, (Date) anunciante.getAno_nascimento());
		statement.setString(5, anunciante.getTelefone());
		statement.setString(6, anunciante.getCelular());
		statement.setString(7, anunciante.getTipo_pessoa());
		statement.setString(8, anunciante.getStatus());
		statement.setInt(9, anunciante.getid_pessoa());

		statement.executeQuery();

		String sql2 = "call buscar_anunciante (?)";
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement2.setInt(1, anunciante.getid_pessoa());
		ResultSet set = statement2.executeQuery();
		Anunciante novo_anunciante = new Anunciante();

		if (set.next()) {
			novo_anunciante.setid_pessoa(set.getInt("id_pessoa"));
			novo_anunciante.setNome(set.getString("nome"));
			novo_anunciante.setCPF(set.getString("CPF"));
			novo_anunciante.setSenha(set.getString("senha"));
			novo_anunciante.setCelular(set.getString("celular"));
			novo_anunciante.setTelefone(set.getString("telefone"));
			novo_anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
			novo_anunciante.setStatus(set.getString("Astatus"));
			novo_anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
		}
		return novo_anunciante;
	}

}
