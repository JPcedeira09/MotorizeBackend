package br.com.motorize.DAOTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
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
		veiculo = new Veiculo(5, "BMW", "M240i", "-", "CARRO");
	}

	@After
	public void tearDown() throws Exception {
		connection.rollback();
		connection.close();
	}

	@Test
	public void deveRetornarCidade() throws SQLExceptions, ClassNotFoundException, SQLException {
		cidade = filtragemDAO.BuscarCidade(1, connection);
		Assert.assertEquals("Sucupira",cidade.getcidade());
	}

	@Test
	public void deveBuscarCidades() throws SQLExceptions, ClassNotFoundException, SQLException {
		cidades = filtragemDAO.BuscarCidades(4, connection);
		Assert.assertEquals("Laranjal Do Jari", cidades.get(3).getcidade());
	}

	@Test
	public void deveBuscarEstado() throws SQLExceptions, ClassNotFoundException, SQLException {
		estado = filtragemDAO.BuscarEstado(1, connection);
		Assert.assertEquals("Acre", estado.getEstado());
	}
	
	@Test
	public void deveBuscarEstados() throws SQLExceptions, ClassNotFoundException, SQLException {
		estados = filtragemDAO.BuscarEstados(connection);
		Assert.assertEquals("Amazonas", estados.get(2).getEstado());
	}
	
	@Test
	public void deveBuscarMarcas() throws SQLExceptions, ClassNotFoundException, SQLException {
		veiculos = filtragemDAO.BuscarMarcas("MOTO", connection);		
		Assert.assertEquals("BUELL", veiculos.get(2).getMarca());
	}

	@Test
	public void deveBuscarModelos() throws SQLExceptions, ClassNotFoundException, SQLException {
		veiculos = filtragemDAO.BuscarModelos(veiculo, connection);	
		Assert.assertEquals("M2", veiculos.get(2).getModelo());
	}
	
	
	@Test
	public void deveBuscarTipoVeiculo() throws SQLExceptions, ClassNotFoundException, SQLException {
		veiculos = filtragemDAO.BuscarTipo_Veiculo(connection);	
		Assert.assertEquals("MOTO", veiculos.get(1).getTipo_veiculo());
	}
	@Test
	public void deveBuscarVersao() throws SQLExceptions, ClassNotFoundException, SQLException {
		veiculos = filtragemDAO.BuscarVersao(veiculo, connection);	
		Assert.assertNull(veiculos.get(0).getVersao());
	}
	

}
