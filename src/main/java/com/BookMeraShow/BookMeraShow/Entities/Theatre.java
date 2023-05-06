package com.BookMeraShow.BookMeraShow.Entities;

// import java.util.List;

// import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "screen_name")
	private String screenName;

	@Column(name = "number_of_seats")
	private int numberOfSeats;

     @Column(name = "theatre_type")
     private String theatreType;

     @Column(name = "location")
     private String location;

	// @OneToMany(mappedBy = "theatre")
	// private List<Show> show;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

     public String getTheatreType() {
          return theatreType;
     }

     public void setTheatreType(String theatreType) {
          this.theatreType = theatreType;
     }

     public String getLocation() {
          return location;
     }

     public void setLocation(String location) {
          this.location = location;
     }


	// public List<Show> getShow() {
	// 	return show;
	// }

	// public void setShow(List<Show> show) {
	// 	this.show = show;
	// }

	public Theatre() {
		super();
	}

}

