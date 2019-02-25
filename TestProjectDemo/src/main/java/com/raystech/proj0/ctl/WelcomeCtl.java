package com.raystech.proj0.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping(value = "/Welcome")
public class WelcomeCtl {
/*  @RequestMapping(method = RequestMethod.GET)
  public String display(ModelMap model) {
    System.out.println("I am in display");
    model.addAttribute("message", "Welcome to Spring MVC!!");
    System.out.println("afterr disply display welvcome");
    return "Welcome";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String submit(Model model) {
    System.out.println("I am in submit");
    model.addAttribute("message", "You sent post request!");
    System.out.println("afterr disply submit welvcome");
    return "Welcome";
  }*/

		@RequestMapping(method = RequestMethod.GET)
		public String display(ModelMap model) {
	System.out.println("=====welcome display");
			return "Welcome";
		}

}
