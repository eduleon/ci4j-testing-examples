package cl.edu.arq.ci4jtestingexamples.dao.interfaces;

import org.springframework.stereotype.Repository;

import cl.edu.arq.ci4jtestingexamples.domain.Snowboard;

@Repository
public interface ISnowboardDAO {
	
	public Snowboard getSnowboard(Double personHeight, Double personWeight);

}
