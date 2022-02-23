package fr.eql.ai110.laserre.controller.restaurant;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;
import fr.eql.ai110.laserre.ibusiness.restaurant.BookingIBusiness;


@ManagedBean(name = "mbUserBook")
@ViewScoped
public class UserBookingManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private List<SocialTableBooking> pastSocialBookings;
	private List<SocialTableBooking> futureSocialBookings;
	
	@EJB
	private BookingIBusiness bookingBU;
	
	@PostConstruct
	void init() {
		pastSocialBookings = new ArrayList<SocialTableBooking>();
		futureSocialBookings = new ArrayList<SocialTableBooking>();
		
		List<SocialTableBooking> socBookings = bookingBU.finbdAllSocialTableBookingByUser(connectedUser);
		for (SocialTableBooking booking : socBookings) {			
			
			
			if (booking.getBookedDate().isBefore(LocalDate.now()) ) {
				pastSocialBookings.add(booking);
			} else {
				futureSocialBookings.add(booking);
			}			
		}
	}
	
	public boolean hasNoSocialBooking() {
		return (futureSocialBookings.isEmpty());
	}
	public boolean hadSubscription() {
		return (!pastSocialBookings.isEmpty());
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public List<SocialTableBooking> getPastSocialBookings() {
		return pastSocialBookings;
	}

	public void setPastSocialBookings(List<SocialTableBooking> pastSocialBookings) {
		this.pastSocialBookings = pastSocialBookings;
	}

	public List<SocialTableBooking> getFutureSocialBookings() {
		return futureSocialBookings;
	}

	public void setFutureSocialBookings(List<SocialTableBooking> futureSocialBookings) {
		this.futureSocialBookings = futureSocialBookings;
	}

	
}
