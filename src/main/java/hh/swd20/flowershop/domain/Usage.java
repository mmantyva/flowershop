package hh.swd20.flowershop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Usage {
	
	@Id
	private String use;
	
	@JsonBackReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy="usage")
	private List<Plant> plants;

	public Usage() {
	}
	
	public Usage(String use) {
		super();
		this.use = use;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	@Override
	public String toString() {
		return "Usage [use=" + use + "]";
	}
	
	
}
