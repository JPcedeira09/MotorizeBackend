package br.com.motorize.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.AcessosInterface;
import br.com.motorize.model.Anunciante;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Email;
import br.com.motorize.model.Endereco;
import br.com.motorize.model.Estado;
import br.com.motorize.model.Tipo_Assinatura;

public class AcessoDAO implements AcessosInterface{

	@Override
	public Anunciante Login(String CPF, String senha,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		Anunciante buscarAnunciante = buscaAnunciantePorID(CPF,connection);

		if (buscarAnunciante == null || buscarAnunciante.getCPF() == "" ) {
			return null;
		}else {


			String query = "call login_base('"+CPF+"', '"+senha+"') ";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			Anunciante anunciante = new Anunciante();

			while(set.next()){

				anunciante.setNome(set.getString("nome"));
				anunciante.setCPF(set.getString("CPF"));
				anunciante.setSenha(set.getString("senha"));
				anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
				anunciante.setTelefone(set.getString("telefone"));
				anunciante.setCelular(set.getString("celular"));
				anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
				anunciante.setid_pessoa(set.getInt("id_pessoa"));		
				anunciante.setStatus(set.getString("Astatus"));
			}
			String updateQuery = "call update_status_service_s('"+CPF+"')";
			PreparedStatement statement2 = connection.prepareStatement(updateQuery);
			statement2.executeQuery();

			Anunciante buscarAnuncianteAtual = buscaAnunciantePorID(CPF,connection);

			while(set.next()){
				buscarAnuncianteAtual.setNome(set.getString("nome"));
				buscarAnuncianteAtual.setCPF(set.getString("CPF"));
				buscarAnuncianteAtual.setSenha(set.getString("senha"));
				buscarAnuncianteAtual.setAno_nascimento(set.getDate("ano_nascimento"));
				buscarAnuncianteAtual.setTelefone(set.getString("telefone"));
				buscarAnuncianteAtual.setCelular(set.getString("celular"));
				buscarAnuncianteAtual.setTipo_pessoa(set.getString("tipo_pessoa"));
				buscarAnuncianteAtual.setid_pessoa(set.getInt("id_pessoa"));		
				buscarAnuncianteAtual.setStatus(set.getString("Astatus"));
			}
			return buscarAnuncianteAtual;
		}
	}

	@Override
	public Anunciante Acesso(String CPF, String senha, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		Anunciante buscarAnunciante = buscaAnunciantePorID(CPF,connection);
		if (buscarAnunciante == null || buscarAnunciante.getCPF() == "" ) {
			return null;
		}else {
			String query = "call login_anunciante(?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, CPF);
			statement.setString(2, senha);
			ResultSet set = statement.executeQuery();

			Anunciante anunciante = new Anunciante();
			Endereco endereco = new Endereco();
			Cidade cidade = new Cidade();
			Estado estado = new Estado();
			Email email = new Email();
			Tipo_Assinatura assinatura = new Tipo_Assinatura();

			while(set.next()){

				anunciante.setNome(set.getString("nome"));
				anunciante.setCPF(set.getString("CPF"));
				anunciante.setSenha(set.getString("senha"));
				anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
				anunciante.setTelefone(set.getString("telefone"));
				anunciante.setCelular(set.getString("celular"));
				anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
				anunciante.setid_pessoa(set.getInt("id_pessoa"));		
				anunciante.setStatus(set.getString("Astatus"));

				endereco.setId_endereco(set.getInt("id_endereco"));
				endereco.setCep(set.getString("cep"));
				endereco.setRua(set.getString("rua"));
				endereco.setNumero(set.getString("numero"));
				endereco.setComplemento(set.getString("complemento"));

				cidade.setId_cidade(set.getInt("id_cidade"));
				cidade.setId_estado(set.getInt("id_estado"));

				estado.setId_estado(set.getInt("id_estado"));
				estado.setEstado(set.getString("estado"));
				estado.setSigla(set.getString("sigla"));

				email.setId_email(set.getInt("id_email"));
				email.setEmail(set.getString("email"));

				assinatura.setId_tipo_assinatura(set.getInt("id_assinatura"));
				assinatura.setNome_assinatura(set.getString("nome_assinatura"));
				assinatura.setValor(set.getInt("valor"));

			}

			String updateQuery = "call update_status_service_s(?)";
			PreparedStatement statement2 = connection.prepareStatement(updateQuery);
			statement2.setInt(1,anunciante.getid_pessoa());
			statement2.executeQuery();

			while(set.next()){
				anunciante.setNome(set.getString("nome"));
				anunciante.setCPF(set.getString("CPF"));
				anunciante.setSenha(set.getString("senha"));
				anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
				anunciante.setTelefone(set.getString("telefone"));
				anunciante.setCelular(set.getString("celular"));
				anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
				anunciante.setid_pessoa(set.getInt("id_pessoa"));		
				anunciante.setStatus(set.getString("Astatus"));

				endereco.setId_endereco(set.getInt("id_endereco"));
				endereco.setCep(set.getString("cep"));
				endereco.setRua(set.getString("rua"));
				endereco.setNumero(set.getString("numero"));
				endereco.setComplemento(set.getString("complemento"));

				cidade.setId_cidade(set.getInt("id_cidade"));
				cidade.setId_estado(set.getInt("id_estado"));

				estado.setId_estado(set.getInt("id_estado"));
				estado.setEstado(set.getString("estado"));
				estado.setSigla(set.getString("sigla"));

				email.setId_email(set.getInt("id_email"));
				email.setEmail(set.getString("email"));

				assinatura.setId_tipo_assinatura(set.getInt("id_assinatura"));
				assinatura.setNome_assinatura(set.getString("nome_assinatura"));
				assinatura.setValor(set.getInt("valor"));
			}
			return anunciante;
		}
	}



	@Override
	public Anunciante Logout(String CPF, Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		Anunciante buscarAnunciante = buscaAnunciantePorID(CPF,connection);
		if (buscarAnunciante == null || buscarAnunciante.getCPF() == "" ) {
			return null;
		}else {
			String updateQuery = "call upadate_status_service_N('"+CPF+"')";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.executeUpdate();
			
			return buscaAnunciantePorID(CPF,connection);
		}
	}

	public Anunciante buscaAnunciantePorID(String CPF, Connection connection) throws SQLException {

		String sqlQuery = "SELECT * FROM anunciante WHERE CPF = '"+CPF+"'";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet set = statement.executeQuery();
		Anunciante anunciante = new Anunciante();

		if (set.next()) {
			anunciante.setNome(set.getString("nome"));
			anunciante.setCPF(set.getString("CPF"));
			anunciante.setSenha(set.getString("senha"));
			anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
			anunciante.setTelefone(set.getString("telefone"));
			anunciante.setCelular(set.getString("celular"));
			anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
			anunciante.setid_pessoa(set.getInt("id_pessoa"));
			anunciante.setStatus(set.getString("Astatus"));
		}
		return anunciante;

	}
}
