package br.com.motorize.DAOTest;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.motorize.DAO.EnderecoDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Endereco;
import br.com.motorize.utils.ConexaoUtil;
import junit.framework.Assert;

public class EnderecoDAOTest {

	private Connection connection;
	private EnderecoDAO enderecoDAO;
	private Endereco endereco;
	private Endereco endereco2;
	private Endereco retornoAddEnd;
	private Endereco retronoUpdate;
	private Endereco retornoDelete;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		connection = ConexaoUtil.getConnection();
		connection.setAutoCommit(false);
		enderecoDAO = new EnderecoDAO();
		endereco = new Endereco(1, 1, "09540500", "Av. Lemos Monteiro", "351", "ap. 82", "Olimpico", 1);
		endereco2 = new Endereco(1, 1, "09540500", "Av. Lemo Monteiro", "351", "ap. 82", "Olimpico", 1);
	}

	@Test
	public void deveAdicionarEndereco() throws SQLExceptions, ClassNotFoundException, SQLException {
		enderecoDAO.AdiconarEndereco(endereco, connection);
		retornoAddEnd = enderecoDAO.BuscarEndereco(1, connection);
		Assert.assertEquals("Av. Lemos Monteiro", retornoAddEnd.getRua());	
	}

	@Test
	public void deveAtualizarEndereco() throws SQLExceptions, ClassNotFoundException, SQLException {
		retronoUpdate = enderecoDAO.UpdateEndereco(endereco2, connection);
		Assert.assertEquals("Av. Lemo Monteiro", retronoUpdate.getRua());
	}

	@Test
	public void deveDeletarEndereco() throws SQLExceptions, ClassNotFoundException, SQLException {
		enderecoDAO.DeletarEndereco(0, connection);
		retornoDelete = enderecoDAO.BuscarEndereco(1, connection);
		Assert.assertNull(retornoDelete.getBairro());
	}

	@After
	public void tearDown() throws SQLException {
		connection.rollback();
		connection.close();
	}

}
