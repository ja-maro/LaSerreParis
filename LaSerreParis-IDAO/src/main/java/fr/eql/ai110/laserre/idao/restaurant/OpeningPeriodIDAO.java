package fr.eql.ai110.laserre.idao.restaurant;

import java.time.LocalDate;

import fr.eql.ai110.laserre.entity.restaurant.OpeningPeriod;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface OpeningPeriodIDAO extends GenericIDAO<OpeningPeriod> {

	/**
	 * Get OpeningPeriod containing the given date.
	 * 
	 * @param day given date
	 * @return OpeningPeriod where given day is comprised between firstDay and lastDay, included
	 */
	OpeningPeriod getByDay(LocalDate day);

}
