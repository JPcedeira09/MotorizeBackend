package br.com.motorize.DAOTest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.motorize.DAO.AnuncianteDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anunciante;
import br.com.motorize.utils.ConexaoUtil;

public class AnuncianteDAOTest {

	private Connection connection ;
	private Anunciante anunciante ;
	private AnuncianteDAO anuncianteDAO;
	private Anunciante anuncianteRetorno;
	private Anunciante anuncianteNovo ;
	private Anunciante anuncianteNovoD;

	@SuppressWarnings("deprecation")
	@Before
	public void abrindoConexao() throws ClassNotFoundException, SQLException{
		connection = ConexaoUtil.getConnection();
		anuncianteDAO = new AnuncianteDAO();
		connection.setAutoCommit(false);

		Date ano_nascimento =  new Date(1996, 9, 9);
		anunciante = new Anunciante("Joao Paulo", "461.878.888-71", "Jpmotorize09@", "42323142", "997485353", "pessoa fisica", "N");
		anuncianteNovo = new Anunciante("Joao Paulo Ferreira", "461.878.888-71", "Jpmotorize09@", ano_nascimento, "42323142", "997485353", "pessoa fisica",1, "N");

	}

	@Test
	public void deveAdicionarAnunciante() throws SQLExceptions, ClassNotFoundException, SQLException{
		anuncianteDAO.AdicionarAnunciante(anunciante,connection);
		anuncianteRetorno = anuncianteDAO.BuscarAnunciante(anunciante.getCPF(), connection);
		Assert.assertEquals("461.878.888-71", anuncianteRetorno.getCPF());
	}

	@Test
	public void deveAtualizarAnunciante() throws SQLExceptions, ClassNotFoundException, SQLException {

		anuncianteDAO.UpdateAnunciante(anuncianteNovo,connection);
		anuncianteRetorno = anuncianteDAO.BuscarAnunciante(anunciante.getCPF(), connection);
		Assert.assertEquals("Joao Paulo Ferreira", anuncianteRetorno.getNome());
	}
	
	@Test
	public void deveDeletarAnunciante() throws SQLExceptions, ClassNotFoundException, SQLException {
		anuncianteRetorno = anuncianteDAO.BuscarAnunciante(anunciante.getCPF(), connection);

		anuncianteDAO.DeletarAnunciante(anuncianteRetorno.getid_pessoa(),connection);
		anuncianteRetorno = anuncianteDAO.BuscarAnunciante(anunciante.getCPF(), connection);
		Assert.assertNull(anuncianteRetorno.getNome());
	}
	
	@After
	public void fechandoConexao() throws SQLException{
		connection.rollback();
		connection.close();
	}

}
