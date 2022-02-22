package fr.eql.ai110.laserre.idao.restaurant;

import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SocialTableIDAO extends GenericIDAO<SocialTable> {

	/**
	 * Returns total number of seats on social tables.
	 * 
	 * @return seats
	 */
	Integer getTotalSeatsNotHidden();
	
	

}
