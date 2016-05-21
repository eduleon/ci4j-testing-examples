import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalServiceConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceConsumer.class);
	
	public Response getResponse() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io").path("v2").path("5185415ba171ea3a00704eed");
		LOGGER.debug("requesting to: {}", target.getUri());
		
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE).put(Entity.text(""));
		LOGGER.debug("response: {}", response);
		return response;
	}

}
