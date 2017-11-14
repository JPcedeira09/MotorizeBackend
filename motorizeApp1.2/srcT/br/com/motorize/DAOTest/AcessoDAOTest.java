package br.com.motorize.DAOTest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;

import br.com.motorize.DAO.AcessoDAO;
import br.com.motorize.DAO.AnuncianteDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anunciante;
import br.com.motorize.utils.ConexaoUtil;

public class AcessoDAOTest {

	private Connection connection ;
	private Anunciante anunciante ;
	private AcessoDAO acessoDAO;
	private AnuncianteDAO anuncianteDAO;
	private Anunciante anuncianteReturn;
	
	@SuppressWarnings("deprecation")
	@Before
	public void abrindoConexao() throws ClassNotFoundException, SQLException{
		connection = ConexaoUtil.getConnection();
		Date ano_nascimento =  new Date(1996, 9, 9);
		anunciante = new Anunciante("Joao Paulo", "461.878.888-71", "Jpmotorize09@", ano_nascimento, "42323142", "997485353", "pessoa fisica", "N");
		anuncianteDAO = new AnuncianteDAO();
		acessoDAO = new AcessoDAO();
		connection.setAutoCommit(false); 
	}

	@Test
	public void deveEncontrarPeloAcesso() throws ClassNotFoundException, SQLException{
		anuncianteDAO.AdicionarAnunciante(anunciante,connection);
		
		anuncianteReturn = acessoDAO.Login(anunciante.getCPF(), anunciante.getSenha(),connection);
		
		Assert.assertEquals("S", anuncianteReturn.getStatus());
		Assert.assertEquals("461.878.888-71", anuncianteReturn.getCPF());
	}

	@Test
	public void deveAtualizarOStatus() throws SQLExceptions, ClassNotFoundException, SQLException{
		acessoDAO.Logout("461.878.888-71", connection);
		Assert.assertEquals("N", anunciante.getStatus());
	}

	@After
	public void fechandoConexao() throws SQLException{
		connection.rollback();
		connection.close();
	}

}
