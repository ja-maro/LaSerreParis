package fr.eql.ai110.laserre.idao.restaurant;

import java.util.List;

import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SocialTableIDAO extends GenericIDAO<SocialTable> {

	/**
	 * Returns total number of seats on social tables with no hideDate.
	 * 
	 * @return seats
	 */
	Integer getTotalSeatsNotHidden();

	/**
	 * Returns all SocialTables with no hideDate.
	 * 
	 * @return list of scial tables with no hideDate
	 */
	List<SocialTable> getAllAvailable();
	
	

}
