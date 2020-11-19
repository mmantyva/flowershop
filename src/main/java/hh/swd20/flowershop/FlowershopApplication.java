package hh.swd20.flowershop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.flowershop.domain.Usage;
import hh.swd20.flowershop.domain.UsageRepository;
import hh.swd20.flowershop.domain.User;
import hh.swd20.flowershop.domain.UserRepository;
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
	public CommandLineRunner flowerRunner(LocationRepository lrepository, PlantRepository prepository, UsageRepository urepository, UserRepository userrepository) {
		return (args) -> {


			// user
			User user1 = new User("admin", "$2a$10$F6MoVkGgyv/ht6QAMMRqzOx0yVvYQoc/owsTruNAIkUPI5G01Xe.6", "ADMIN");
			userrepository.save(user1);
			
			// location demo data
			lrepository.save(new Location("In store"));
			lrepository.save(new Location("In warehouse"));
			lrepository.save(new Location("Out of stock"));
			
			// usage demo data
			Usage option1 = new Usage("Potted plant");
			Usage option2 = new Usage("Very big plant");
			Usage option3 = new Usage("Edible");
			Usage option4 = new Usage("Accessories");
			urepository.save(option1);
			urepository.save(option2);
			urepository.save(option3);
			urepository.save(option4);
			

			// plant demo data
			prepository.save(new Plant("Raspberry", "Rubus idaeus", 35.00, lrepository.findByLocName("Out of stock").get(0), option3));
			prepository.save(new Plant("Spath", "Spathiphyllum", 7.99, lrepository.findByLocName("In store").get(0), option1));
			prepository.save(new Plant("Christmas tree", "Picea abies", 70.00, lrepository.findByLocName("In warehouse").get(0), option2));
			prepository.save(new Plant("Ugly plastic statuette", "", 12.50, lrepository.findByLocName("In store").get(0), option4));
			prepository.save(new Plant("Basil", "Ocimum basilicum", 3.99, lrepository.findByLocName("In store").get(0), option3));
			prepository.save(new Plant("White ceramic pot, 15 cm", "", 10.00, lrepository.findByLocName("In warehouse").get(0), option4));
		};
	}

}
