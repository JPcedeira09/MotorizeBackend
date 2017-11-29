package br.com.motorize.controller.path;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.motorize.DAO.FiltragemDAO;
import br.com.motorize.model.Anuncio;
import br.com.motorize.model.Cidade;
import br.com.motorize.model.Estado;
import br.com.motorize.model.Veiculo;
import br.com.motorize.utils.ConexaoUtil;

@Path("/filter")
@Consumes("application/json")
@Produces("application/json")
@Singleton
public class FiltragemControllerPath {

	@GET
	@Path("/BuscarMarcas/{tipo_veiculo}")
	public List<Veiculo> BuscarMarcas(@PathParam("tipo_veiculo")String tipo_veiculo){
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

	@GET
	@Path("/BuscarTipoVeiculo")
	public List<Veiculo> BuscarTipoVeiculo(){
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
	
	@GET
	@Path("/BuscarModelos")
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
	
	@GET
	@Path("/BuscarVersao")
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

	@GET
	@Path("/BuscarEstado")
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

	@GET
	@Path("/BuscarCidade")
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

	@GET
	@Path("/BuscarEstados")
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

	@GET
	@Path("/BuscarCidades/{id_estado}")
	public List<Cidade> BuscarCidades(@PathParam("id_estado") long id_estado){
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
	
	@GET
	@Path("/OrdenarVeiculosPorOrdemNatural/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorOrdemNatural(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorOrdemNatural(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorMenorValor/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorMenorValor(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorMenorValor(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorMaiorValor/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorMaiorValor(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorMaiorValor(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorMenorKilometragem/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorMenorKilometragem(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorMenorKilometragem(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorMaiorKilometragem/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorMaiorKilometragem(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorMaiorKilometragem(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorOrdemAlfabeticaAZ/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorOrdemAlfabeticaAZ(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorOrdemAlfabeticaAZ(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorOrdemAlfabeticaZA/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorOrdemAlfabeticaZA(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorOrdemAlfabeticaZA(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorMaisNovo/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorMaisNovo(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorMaisNovo(tipo_veiculo, connection);
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
	
	@GET
	@Path("/OrdenarVeiculosPorMaisVelho/{tipo_veiculo}")
	public List<Anuncio> OrdenarVeiculosPorMaisVelho(@PathParam("tipo_veiculo") String tipo_veiculo){
		try {
			Connection connection = ConexaoUtil.getConnection();
			return new FiltragemDAO().OrdenarVeiculosPorMaisVelho(tipo_veiculo, connection);
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
