package hh.swd20.flowershop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long locId;
	
	@Size(min=2, max=100, message="Location name must be at least 2 characters")
	private String locName;
	
	private String address;
	private String phone;
	
	@Size(min=2, max=100, message="Contact name must be at least 2 characters")
	private String contact;
	
	@JsonBackReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy="location")
	private List<Plant> plants;
	
	public Location() {
	}
	
	public Location(String locName, String address, String phone, String contact) {
		super();
		this.locName = locName;
		this.address = address;
		this.phone = phone;
		this.contact = contact;
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<Plant> getPlants() {
		return plants;
	}

	public void setStudents(List<Plant> plants) {
		this.plants = plants;
	}

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + ", address=" + address + ", phone=" + phone
				+ ", contact=" + contact + "]";
	}	


	
	
}
