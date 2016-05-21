import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class ExternalServiceConsumerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceConsumerTest.class);

	@Mock
	private ExternalServiceConsumer mockedConsumer;

	@Mock
	private Response mockedResponse;
	
	@Test
	public void testGetResponse() {
		Response response = new ExternalServiceConsumer().getResponse();
		Assert.assertEquals(200L, response.getStatus());
	}

	@Test
	public void testGetResponseMocked() {
		
		LOGGER.debug("mocked consumer: {}", mockedConsumer);

		// define return value for method getResponse()
		when(mockedConsumer.getResponse()).thenReturn(mockedResponse);
		when(mockedResponse.getStatus()).thenReturn(201);
		
		Response response = mockedConsumer.getResponse();
		Assert.assertEquals(201L, response.getStatus());
	}

}
