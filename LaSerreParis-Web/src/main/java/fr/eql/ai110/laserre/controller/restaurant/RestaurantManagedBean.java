package fr.eql.ai110.laserre.controller.restaurant;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbRestaurant")
@SessionScoped
public class RestaurantManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

//	private List<LocalDate> nextSevenDays;
	private LocalDate day;
	
	@PostConstruct
	public void init() {
		day = LocalDate.now();
	}
}
