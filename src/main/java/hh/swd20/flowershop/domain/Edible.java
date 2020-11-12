//package hh.swd20.flowershop.domain;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Edible {
//	
//	@Id
//	private String edibility;
//	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="edible")
//	private List<Plant> plants;
//
//	public Edible() {
//	}
//	
//	public Edible(String edibility) {
//		super();
//		this.edibility = edibility;
//	}
//
//	public String getEdibility() {
//		return edibility;
//	}
//
//	public void setEdibility(String edibility) {
//		this.edibility = edibility;
//	}
//
//	@Override
//	public String toString() {
//		return "Edible [edibility=" + edibility + "]";
//	}
//	
//	
//}
