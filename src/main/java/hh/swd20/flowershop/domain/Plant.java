package hh.swd20.flowershop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Plant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long plantId;
	private String name, latin;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="locId")
	private Location location;
	
//	@ManyToOne
//	@JoinColumn(name="edibility")
//	private Edible edible;
//	
	public Plant() {

	}
	
	public Plant(String name, String latin, double price, Location location) {
		super();
		this.name = name;
		this.latin = latin;
		this.price = price;
		this.location = location;
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
	
//	public Edible getEdible() {
//		return edible;
//	}
//	
//	public void setEdible(Edible edible) {
//		this.edible = edible;
//	}

	@Override
	public String toString() {
		return "Plant [name=" + name + ", price=" + price + "]";
	}

}