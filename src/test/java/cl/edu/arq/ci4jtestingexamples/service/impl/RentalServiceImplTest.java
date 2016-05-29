package cl.edu.arq.ci4jtestingexamples.service.impl;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import cl.edu.arq.ci4jtestingexamples.dao.interfaces.ISnowboardDAO;
import cl.edu.arq.ci4jtestingexamples.domain.Snowboard;
import cl.edu.arq.ci4jtestingexamples.resource.SnowboardResource;
import cl.edu.arq.ci4jtestingexamples.service.interfaces.IRentalService;

@RunWith(MockitoJUnitRunner.class)
public class RentalServiceImplTest {

	@Mock
	private ISnowboardDAO snowboardDAO;

	@InjectMocks
	private IRentalService rentalService = new RentalServiceImpl();

	@Before
	public void mockRentalService() {
		when(snowboardDAO.getSnowboard(anyDouble(), anyDouble())).thenReturn(new Snowboard());
	}

	@Test
	public void testGetSnowboard() {

		SnowboardResource snowboardResource = rentalService.getSnowboard(1.70, 70.5);

		Assert.assertNotNull(snowboardResource);
	}

}
