package hh.swd20.flowershop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.flowershop.web.PlantController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FlowershopApplicationTests {

	@Autowired
	private PlantController plantController;
	
	@Test
	public void contextLoads() {
		assertThat(plantController).isNotNull();
	}
}
