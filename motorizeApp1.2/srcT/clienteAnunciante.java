

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import br.com.motorize.model.Anunciante;

public class clienteAnunciante {

	public static void main(String[] args) throws ParseException {

		
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				java.sql.Date sqlDate = new java.sql.Date(df.parse("09-09-1968").getTime());
				

				Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
				WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("employees");
				 
				Anunciante input = new Anunciante("Robert", "461.888.878-78", "senhaT", sqlDate, "4232-3636", "99748-5959", "Fisica", "N");

				 
				Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
				Response response = invocationBuilder.post(Entity.entity(input, MediaType.APPLICATION_JSON));
				 
				System.out.println(response.getStatus());
				System.out.println(response.readEntity(String.class));
				 
		}
}
