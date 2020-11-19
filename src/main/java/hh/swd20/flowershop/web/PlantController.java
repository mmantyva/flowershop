package hh.swd20.flowershop.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import hh.swd20.flowershop.domain.UsageRepository;
import hh.swd20.flowershop.domain.LocationRepository;

import hh.swd20.flowershop.domain.Plant;
import hh.swd20.flowershop.domain.PlantRepository;

	
@Controller
	public class PlantController {
	@Autowired
	private PlantRepository prepository;
	@Autowired
	private LocationRepository lrepository;
	@Autowired	
	private UsageRepository urepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value="/success")
    public String success() {	
        return "success";
    }
	
	// näytä kaikki
	@RequestMapping("/inventory")
	public String everything(Model model) {
		model.addAttribute("plants", prepository.findAll());
		return "inventory";
	}
	
	// REST, näytä kaikki
    @GetMapping(value="/allrest")
    public @ResponseBody List<Plant> allRest() {	
        return (List<Plant>) prepository.findAll();
    } 
    
	// REST, hae yksi id:n perusteella
    @GetMapping(value="/allrest/{id}")
    public @ResponseBody Optional<Plant> oneRest(@PathVariable("id") Long plantId) {	
    	return prepository.findById(plantId);
    } 
	
    // poisto
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value="/delete/{plantId}")
	public String deleteItem(@PathVariable("plantId") Long itemId, Model model) {
		prepository.deleteById(itemId);
		return "redirect:../inventory";
	}
    
	
	// lisäys
	@GetMapping(value="/add")
	public String addItem(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("locations", lrepository.findAll());
		model.addAttribute("uses", urepository.findAll());
		return "additem";
	}

	// lisäyksen tallennus
	@PostMapping(value="/add")
	public String saveItem(@Valid Plant plant, BindingResult bindingResult, Model model) {		
		if (bindingResult.hasErrors()) {
        	return "additem";
        } else {
        	prepository.save(plant);
        	return "success";
        }
	}
	
	// muokkaus
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/edit/{plantId}", method=RequestMethod.GET)
    public String editItem(@PathVariable("plantId") Long itemId, Model model) {
    	model.addAttribute("plant", prepository.findById(itemId));
    	model.addAttribute("locations", lrepository.findAll());   	
    	model.addAttribute("uses", urepository.findAll());
		return "edititem";
    }
	
}



