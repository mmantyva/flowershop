package hh.swd20.flowershop.web;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.flowershop.domain.Message;


@Controller
public class MessageController {

	// Empty message form
    @RequestMapping(value="/message", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("message", new Message());
        return "messageform";
    }

    // Handing input from message form
    @RequestMapping(value="/message", method=RequestMethod.POST)
    public String greetingSubmit(@Valid Message msg, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) { // validation errors 
			return "messageform";  // return back to form
		} else { // no validation errors
			model.addAttribute("message", msg);
			return "result";
		}
    }

}