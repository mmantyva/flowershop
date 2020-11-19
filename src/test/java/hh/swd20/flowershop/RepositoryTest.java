package hh.swd20.flowershop;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.flowershop.domain.Plant;
import hh.swd20.flowershop.domain.PlantRepository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {
	
	@Autowired
	private PlantRepository prepository;
	
	@Test
	public void testName() {
	List<Plant> plants = prepository.findByName("Christmas tree");
	assertThat(plants).hasSize(2); // pitää antaa failure, koska oikea on 1
	}
	
}
