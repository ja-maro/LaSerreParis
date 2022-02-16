package fr.eql.ai110.laserre.entity.restaurant;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("private")
@Table(name = "private_table_booking")
public class PrivateTableBooking extends Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private RestaurantTable table;

	
	public PrivateTableBooking() {}

	public PrivateTableBooking(RestaurantTable table) {
		super();
		this.table = table;
	}

	public RestaurantTable getTable() {
		return table;
	}
	public void setTable(RestaurantTable table) {
		this.table = table;
	}

	

}

