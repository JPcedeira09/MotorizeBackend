package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.motorize.model.Anunciante;
import br.com.motorize.utils.ConexaoUtil;

@Path("/anunciante")
@Consumes("application/json")
@Produces("application/json")
public class AnuncianteControllerPath {

	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<h1>Hello World</h1>";
	}
	
	public Anunciante validarAnuncianteExistente(long id) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getConnection();
		String sql = "call buscar_anunciante (?)";
		PreparedStatement statement2 = connection.prepareStatement(sql);
		statement2.setLong(1, id);
		ResultSet set = statement2.executeQuery();
		Anunciante anunciante = new Anunciante();
		if (set.next()) {
			anunciante.setid_pessoa(set.getInt("id_pessoa"));
			anunciante.setNome(set.getString("nome"));
			anunciante.setCPF(set.getString("CPF"));
			anunciante.setSenha(set.getString("senha"));
			anunciante.setCelular(set.getString("celular"));
			anunciante.setTelefone(set.getString("telefone"));
			anunciante.setTipo_pessoa(set.getString("tipo_pessoa"));
			anunciante.setStatus(set.getString("Astatus"));
			anunciante.setAno_nascimento(set.getDate("ano_nascimento"));
		}
		return anunciante;
	}
	
	
	
	
}
