package br.com.motorize.DAOTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.motorize.DAO.FiltragemDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Estado;
import br.com.motorize.model.Veiculo;
import br.com.motorize.utils.ConexaoUtil;

public class FiltragemDAOTest {

	
	private Connection connection;
	private List<Veiculo> veiculos; 
	private Estado estado;
	private Cidade cidade; 
	private  List<Estado> estados;
	private  List<Cidade> cidades;
	private FiltragemDAO filtragemDAO;
	private Veiculo veiculo;
	@Before
	public void setUp() throws Exception {
		connection = ConexaoUtil.getConnection();
		connection.setAutoCommit(false);
		estado = new Estado();
		cidade = new Cidade();
		veiculos = new ArrayList<>();
		estados = new ArrayList<>();
		cidades = new ArrayList<>();
		filtragemDAO = new FiltragemDAO();
		veiculo = new Veiculo(5, "", "", "", "");
	}

	@After
	public void tearDown() throws Exception {
		connection.rollback();
		connection.close();
	}

	@Test
	public void test() throws SQLExceptions, ClassNotFoundException, SQLException {
		
		filtragemDAO.BuscarCidade(1, connection);
		filtragemDAO.BuscarCidades(5, connection);
		filtragemDAO.BuscarEstado(1, connection);
		filtragemDAO.BuscarEstados(connection);
		filtragemDAO.BuscarMarcas("", connection);
		filtragemDAO.BuscarModelos(veiculo, connection);
		filtragemDAO.BuscarTipo_Veiculo(connection);
		filtragemDAO.BuscarVersao(veiculo, connection);
	}

}
