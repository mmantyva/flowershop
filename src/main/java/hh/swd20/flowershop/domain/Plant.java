package hh.swd20.flowershop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Plant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long plantId;
	private String name;
	private String latin;
	private double price;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="locId")
	private Location location;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="use")
	private Usage usage;
	
	public Plant() {

	}
	
	public Plant(String name, String latin, double price, Location location, Usage usage) {
		super();
		this.name = name;
		this.latin = latin;
		this.price = price;
		this.location = location;
		this.usage = usage;
	}

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}

	public String getName() {
		return name;
	}

	public void setLatin(String latin) {
		this.latin = latin;
	}
	
	public String getLatin() {
		return latin;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Usage getUsage() {
		return usage;
	}
	
	public void setUsage(Usage usage) {
		this.usage = usage;
	}

	@Override
	public String toString() {
		return "Plant [name=" + name + ", latin=" + latin + ", price=" + price + ", location=" + location + ", usage="
				+ usage + "]";
	}


}