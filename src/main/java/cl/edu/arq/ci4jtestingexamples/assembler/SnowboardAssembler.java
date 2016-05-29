package cl.edu.arq.ci4jtestingexamples.assembler;

import cl.edu.arq.ci4jtestingexamples.domain.Snowboard;
import cl.edu.arq.ci4jtestingexamples.resource.SnowboardResource;

public class SnowboardAssembler {
	
	public static SnowboardResource toResource(Snowboard snowboard) {
		return snowboard != null ? new SnowboardResource() : null;
	}

}
