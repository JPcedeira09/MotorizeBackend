package br.com.motorize.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.interfaces.FiltragemInterface;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Estado;
import br.com.motorize.model.Veiculo;

public class FiltragemDAO implements FiltragemInterface{

	@Override
	public List<Veiculo> BuscarMarcas(String tipo_veiculo,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {

		String sqlQuery = "call buscar_marcas(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, tipo_veiculo);
		ResultSet set = statement.executeQuery();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		while (set.next()) {
			Veiculo veiculo = new Veiculo();
			
			veiculo.setMarca(set.getString("marca"));
			veiculo.setTipo_veiculo(set.getString("tipo_veiculo"));
			
			veiculos.add(veiculo);
		}
		return veiculos;
	}

	@Override
	public List<Veiculo> BuscarTipo_Veiculo(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_tipo_veiculos";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet set = statement.executeQuery(sqlQuery);
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		while (set.next()) {
			Veiculo veiculo = new Veiculo();
			veiculo.setTipo_veiculo(set.getString("tipo_veiculo"));
			veiculos.add(veiculo);
		}
		return veiculos;
	}

	@Override
	public List<Veiculo> BuscarModelos(Veiculo veiculo,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		
		String sqlQuery = "call buscar_modelos(?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, veiculo.getMarca());
		statement.setString(2, veiculo.getTipo_veiculo());
		ResultSet set = statement.executeQuery();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		while (set.next()) {
			Veiculo retorno = new Veiculo();
			retorno.setMarca(set.getString("marca"));
			retorno.setModelo(set.getString("modelo"));
			retorno.setTipo_veiculo(set.getString("tipo_veiculo"));
			veiculos.add(retorno);
		}
		return veiculos;
	}

	@Override
	public List<Veiculo> BuscarVersao(Veiculo veiculo,Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_versao(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, veiculo.getMarca());
		statement.setString(2, veiculo.getModelo());
		statement.setString(3, veiculo.getTipo_veiculo());
		ResultSet set = statement.executeQuery();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		while (set.next()) {
			Veiculo retorno = new Veiculo();
			retorno.setMarca(set.getString("marca"));
			retorno.setModelo(set.getString("modelo"));
			retorno.setTipo_veiculo(set.getString("versao"));
			retorno.setTipo_veiculo(set.getString("tipo_veiculo"));
			veiculos.add(retorno);
		}
		return veiculos;
	}

	@Override
	public Estado BuscarEstado(int id_estado,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_estado(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_estado);
		ResultSet set = statement.executeQuery();
		Estado estado = new Estado();

		while (set.next()) {
			
			estado.setId_estado(set.getInt("id_estado"));
			estado.setEstado(set.getString("estado"));
			estado.setSigla(set.getString("sigla"));
					}
		return estado;
	}

	@Override
	public Cidade BuscarCidade(int id_cidade,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_cidade(?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_cidade);
		ResultSet set = statement.executeQuery();
		Cidade cidade = new Cidade();
		while (set.next()) {
			cidade.setId_estado(set.getInt("id_estado"));
			cidade.setcidade(set.getString("cidade"));
			cidade.setId_cidade(set.getInt("id_cidade"));
					}
		return cidade;
	}

	@Override
	public List<Estado> BuscarEstados(Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call motorize.buscar_estados()";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet set = statement.executeQuery();
		List<Estado> estados = new ArrayList<Estado>();

		while (set.next()) {
			Estado estado = new Estado();
			estado.setId_estado(set.getInt("id_estado"));
			estado.setEstado(set.getString("estado"));
			estado.setSigla(set.getString("sigla"));
			estados.add(estado);			
		}
		return estados;
	}

	@Override
	public List<Cidade> BuscarCidades(int id_estado,Connection connection) throws SQLExceptions, ClassNotFoundException, SQLException {
		String sqlQuery = "call buscar_cidades(?) ";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, id_estado);
		ResultSet set = statement.executeQuery();
		List<Cidade> cidades = new ArrayList<Cidade>();
		while (set.next()) {
			Cidade cidade = new Cidade();
			cidade.setId_estado(set.getInt("id_estado"));
			cidade.setcidade(set.getString("cidade"));
			cidade.setId_cidade(set.getInt("id_cidade"));
			cidades.add(cidade);			
		}
		return cidades;
	}

	@Override
	public List<Veiculo> OrdenarVeiculosPorX(Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		// TODO FATORAR TODAS AS QUERIES NO BANCO DE ORDENAÇÃO 
		return null;
	}

	@Override
	public List<Veiculo> OrdenarVeiculosPorY(Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> OrdenarVeiculosPorZ(Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> OrdenarVeiculosPorW(Connection connection)
			throws SQLExceptions, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
