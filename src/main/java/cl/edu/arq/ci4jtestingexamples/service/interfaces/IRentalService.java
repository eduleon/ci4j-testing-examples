package cl.edu.arq.ci4jtestingexamples.service.interfaces;

import cl.edu.arq.ci4jtestingexamples.resource.SnowboardResource;

public interface IRentalService {
	
	public SnowboardResource getSnowboard(Double personHeight, Double personWeight);

}
