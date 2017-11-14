package br.com.motorize.DAOTest;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.motorize.DAO.AssinaturaDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Assinature;
import br.com.motorize.utils.ConexaoUtil;

public class AssinaturaDAOTest {

	private Connection connection ;
	private AssinaturaDAO assinaturaDAO;
	private Assinature assinatura;
	private Assinature retonoAtualizacao;
	private Assinature assinaturaAdd;
	private Assinature assinatura2;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		connection = ConexaoUtil.getConnection();
		connection.setAutoCommit(false);
		assinaturaDAO = new AssinaturaDAO();
		assinatura = new Assinature(25,1, 2);
		assinatura2 = new Assinature(24,1,2, 2);

	}
	@After
	public void tearDown() throws SQLException  {
		connection.rollback();
		connection.close();
	}
	@Test
	public void deveAdicionarAssinatura() throws SQLExceptions, ClassNotFoundException, SQLException {
		assinaturaDAO.AdicionarAssinatura(assinatura, connection);
	}
	@Test
	public void deveBuscarAssinatura() throws SQLExceptions, ClassNotFoundException, SQLException {
		assinaturaAdd = assinaturaDAO.BuscarAssinatura(1, connection);
		Assert.assertEquals(1, assinaturaAdd.getId_pessoa_fk());
	}
	@Test
	public void deveAtualizarAssinatura() throws SQLExceptions, ClassNotFoundException, SQLException {
		retonoAtualizacao = assinaturaDAO.AtualizarAssinatura(assinatura2, connection);
		Assert.assertEquals(2,retonoAtualizacao.getId_tipoAssinatura());
	    Assert.assertEquals(2,retonoAtualizacao.getid_status());
	}
	@Test
	public void deveDeletarAssinatura() throws SQLExceptions, ClassNotFoundException, SQLException {
		assinaturaDAO.DeletarAssinatura(25, connection);

	}

}
