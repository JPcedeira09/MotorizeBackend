package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.motorize.DAO.FiltragemDAO;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Estado;
import br.com.motorize.model.Veiculo;
import br.com.motorize.utils.ConexaoUtil;

@Path("/filter")
@Consumes("application/json")
@Produces("application/json")
public class FiltragemControllerPath {


	public List<Veiculo> BuscarMarcas(String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarMarcas(tipo_veiculo, connection);
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

	public List<Veiculo> BuscarTipo_Veiculo(){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarTipo_Veiculo(connection);
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

	public List<Veiculo> BuscarModelos(Veiculo veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarModelos(veiculo, connection);
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

	public List<Veiculo> BuscarVersao(Veiculo veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarVersao(veiculo, connection);
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

	public Estado BuscarEstado(int id_estado){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarEstado(id_estado, connection);
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

	public Cidade BuscarCidade(int id_cidade){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarCidade(id_cidade, connection);
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

	public List<Estado> BuscarEstados(){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarEstados(connection);
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

	public List<Cidade> BuscarCidades(int id_estado){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().BuscarCidades(id_estado, connection);
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
