package cl.edu.arq.ci4jtestingexamples.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cl.edu.arq.ci4jtestingexamples.assembler.SnowboardAssembler;
import cl.edu.arq.ci4jtestingexamples.dao.interfaces.ISnowboardDAO;
import cl.edu.arq.ci4jtestingexamples.domain.Snowboard;
import cl.edu.arq.ci4jtestingexamples.resource.SnowboardResource;
import cl.edu.arq.ci4jtestingexamples.service.interfaces.IRentalService;

@Service
public class RentalServiceImpl implements IRentalService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RentalServiceImpl.class);

	@Inject
	private ISnowboardDAO snowboardDAO;

	public RentalServiceImpl() {
	}

	@Override
	public SnowboardResource getSnowboard(Double personHeight, Double personWeight) {

		LOGGER.info("Getting a snowboard for a person who is {} meters high and weighs {} kg.", personHeight, personWeight);
		Snowboard snowboard = snowboardDAO.getSnowboard(personHeight, personWeight);
		LOGGER.debug("Snowboard: {}", snowboard);
		
		return SnowboardAssembler.toResource(snowboard);
	}

}
