package hh.swd20.flowershop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Plant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long plantId;
	@NotNull(message="Name can't be empty")
	@Size(min=2, max=100, message="Name must be at least 2 characters")
	private String name;
	private String latin;
	@NotNull(message="Price can't be empty")	
	private double price;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="locId")
	@NotNull(message="Please select item location")
	private Location location;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="use")
	@NotNull(message="Please select item usage")
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