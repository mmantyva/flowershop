package hh.swd20.flowershop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long locId;
	private String locName;
	
	@JsonBackReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy="location")
	private List<Plant> plants;
	
	public Location() {
	}
	
	public Location(String locName) {
		super();
		this.locName = locName;
	}

	public long getLocId() {
		return locId;
	}

	public void setLocId(long locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}
	
	public List<Plant> getPlants() {
		return plants;
	}

	public void setStudents(List<Plant> plants) {
		this.plants = plants;
	}	

	@Override
	public String toString() {
		return "Location [locId=" + locId + "locName=" + locName + "]";
	}
	
	
}
