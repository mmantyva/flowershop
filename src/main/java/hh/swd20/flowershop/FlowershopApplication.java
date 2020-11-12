package hh.swd20.flowershop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import hh.swd20.flowershop.domain.Edible;
//import hh.swd20.flowershop.domain.EdibleRepository;
import hh.swd20.flowershop.domain.Location;
import hh.swd20.flowershop.domain.LocationRepository;
import hh.swd20.flowershop.domain.Plant;
import hh.swd20.flowershop.domain.PlantRepository;

@SpringBootApplication
public class FlowershopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowershopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner flowerRunner(LocationRepository lrepository, PlantRepository prepository) {
		return (args) -> {

			// location demo data
			lrepository.save(new Location("In store"));
			lrepository.save(new Location("In warehouse"));
			lrepository.save(new Location("Out of stock"));
			
//			// edibility demo data
//			Edible option1 = new Edible("Yes");
//			Edible option2 = new Edible("No");
//			Edible option3 = new Edible("Not poisonous but tastes bad");

			// plant demo data
			prepository.save(new Plant("Raspberry", "Rubus idaeus", 35.00, lrepository.findByLocName("Out of stock").get(0)));
			prepository.save(new Plant("Spath", "Spathiphyllum", 7.00, lrepository.findByLocName("In store").get(0)));
			prepository.save(new Plant("Christmas tree", "Picea abies", 70.00, lrepository.findByLocName("In warehouse").get(0)));
		};
	}

}
