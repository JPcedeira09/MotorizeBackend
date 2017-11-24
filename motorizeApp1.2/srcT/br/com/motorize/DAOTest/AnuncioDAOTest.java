package br.com.motorize.DAOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.motorize.DAO.AnuncioDAO;
import br.com.motorize.exception.SQLExceptions;
import br.com.motorize.model.Anuncio;
import br.com.motorize.utils.ConexaoUtil;

public class AnuncioDAOTest {

	private Connection connection ;
	private Anuncio anuncio1;
	private Anuncio anuncio2;
	private Anuncio anuncio3;
	private AnuncioDAO anucioDAO;

	private File imagem_1;
	private File imagem_2;
	private File imagem_3;
	private File imagem_4;
	private List<Anuncio> buscarAnunciosID;
	private Anuncio anuncioUpdate;
	private Anuncio atualizado;

	@SuppressWarnings("deprecation")
	@Before
	public void deveInicializarAsInstancias() throws ClassNotFoundException, SQLException, FileNotFoundException{
		connection = ConexaoUtil.getConnection();
		connection.setAutoCommit(false);
		Date dataPost =  new Date(2017, 9, 9);
		Date ano_compra =  new Date(1996, 9, 9);
		imagem_1 = new File("/Users/JohnnyCedeira/Desktop/carros/carro4.jpg");
		imagem_2 = new File("/Users/JohnnyCedeira/Desktop/carros/carro4.jpg");
		imagem_3 = new File("/Users/JohnnyCedeira/Desktop/carros/carro4.jpg");
		imagem_4 = new File("/Users/JohnnyCedeira/Desktop/carros/carro4.jpg");

		FileInputStream fileInp1 = new FileInputStream(imagem_1);
		FileInputStream fileInp2 = new FileInputStream(imagem_2);
		FileInputStream fileInp3 = new FileInputStream(imagem_3);
		FileInputStream fileInp4 = new FileInputStream(imagem_4);

		anuncio1 = new Anuncio(20000.50, dataPost, ano_compra, "azul", "sem opcionais", "Tipo A4", 90000 ,4, "nenhuma", "codigoTest1", fileInp1, fileInp2, fileInp3, fileInp4,4, 1);
		anuncio2 = new Anuncio(23000.50, dataPost, ano_compra, "azul", "sem opcionais", "Tipo A1", 90500 ,4, "nenhuma", "codigoTest2", fileInp1, fileInp2, fileInp3, fileInp4,2, 1);
		anuncio3 = new Anuncio( 27000.50, dataPost, ano_compra, "azul", "sem opcionais", "sem", 96000 ,4, "nenhuma", "codigoTest3", fileInp1, fileInp2, fileInp3, fileInp4,70, 1);
	}

	@Test
	public void deveAdicionarAnuncio() throws SQLExceptions, ClassNotFoundException, SQLException{
		anucioDAO.AdicionarAnuncio(anuncio1, connection);
		anucioDAO.AdicionarAnuncio(anuncio2, connection);
		anucioDAO.AdicionarAnuncio(anuncio3, connection);
	}

	@Test
	public void deveBuscarAnuncio() throws SQLExceptions, ClassNotFoundException, SQLException {
		anuncioUpdate =	anucioDAO.BuscarAnuncioID(10, connection);
		Assert.assertEquals("codigoTest1", anuncioUpdate.getCodigo());
	}

	@Test
	public void deveBuscarAnuncios() throws SQLExceptions, ClassNotFoundException, SQLException {
		buscarAnunciosID = anucioDAO.BuscarAnunciosID(1, connection);
		
		Assert.assertEquals(12, buscarAnunciosID.get(2).getId_produto());
	}

	@Test
	public void deveAtualizarAnuncio() throws SQLExceptions, ClassNotFoundException, SQLException {
		anuncioUpdate =	anucioDAO.BuscarAnuncioID(11, connection);
		anuncioUpdate.setCodigo("novo codigo");
		atualizado = anucioDAO.UpdateAnuncio(anuncioUpdate, connection);
		Assert.assertEquals("novo codigo", atualizado.getCodigo());
	}

	@After
	public void quandoTerminar() throws SQLException{
		connection.rollback();
		connection.close();
	}

}
