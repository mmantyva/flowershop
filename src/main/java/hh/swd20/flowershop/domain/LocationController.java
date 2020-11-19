package hh.swd20.flowershop.domain;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {
	@Autowired
	private LocationRepository lrepository;
	
	// Empty message form
    @GetMapping(value="/addloc")
    public String locationForm(Model model) {
        model.addAttribute("location", new Location());
        return "locationform";
    }

    // Handing input from message form
    @PostMapping(value="/addloc")
    public String locationSave(@Valid Location loc, BindingResult result, Model model) {
		if (result.hasErrors()) { // validation errors 
			return "locationform";  // return back to form
		} else { // no validation errors
			lrepository.save(loc);
			return "success";
		}
    }

}
