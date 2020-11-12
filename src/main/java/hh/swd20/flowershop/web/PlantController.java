package hh.swd20.flowershop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import hh.swd20.flowershop.domain.EdibleRepository;
import hh.swd20.flowershop.domain.LocationRepository;
import hh.swd20.flowershop.domain.Plant;
import hh.swd20.flowershop.domain.PlantRepository;

	
@Controller
	public class PlantController {
	@Autowired
	private PlantRepository prepository;
	@Autowired
	private LocationRepository lrepository;
//	@Autowired	
//	private EdibleRepository erepository;
	
	@RequestMapping(value="/admin")
    public String admin() {	
        return "admin";
    }	
	
	@RequestMapping("/inventory")
	public String everything(Model model) {
		model.addAttribute("plants", prepository.findAll());
		return "inventory";
	}
	
	@GetMapping(value="/delete/{plantId}")
	public String deleteItem(@PathVariable("plantId") Long itemId, Model model) {
		prepository.deleteById(itemId);
		return "redirect:../inventory";
	}
	
	@RequestMapping(value="/add")
	public String addItem(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("locations", lrepository.findAll());
//		model.addAttribute("edibility", erepository.findAll());
		return "additem";
	}
	
	@PostMapping(value="/save")
	public String saveItem(Plant plant) {
		prepository.save(plant);
		return "redirect:inventory";
	}
	
    @GetMapping(value="/edit/{plantId}")
    public String editItem(@PathVariable("plantId") Long itemId, Model model) {
    	model.addAttribute("plant", prepository.findById(itemId));
    	model.addAttribute("location", lrepository.findAll());   	
		return "edititem";
    }

}



