package com.codingdojo.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.models.Ninja;
import com.codingdojo.dojosAndNinjas.services.DojoService;
import com.codingdojo.dojosAndNinjas.services.NinjaService;


@Controller
public class NinjasController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
    
    public NinjasController (NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService=dojoService;
    }

    @RequestMapping("/ninjas")
	public String NewNinja(@ModelAttribute("form") Ninja ninja, Model model) {
		List<Dojo> dojoList = dojoService.allDojos();
		
		model.addAttribute("dojos", dojoList);
		return "newNinja.jsp";
	}
		
		
		
		   @RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
		    public String create(@Valid @ModelAttribute("form") Ninja ninja, BindingResult result) {
		        if (result.hasErrors()) {
		            return "newNinja.jsp";
		        } else {
		            ninjaService.createNinja(ninja);
		            return "redirect:/ninjas";
		        }
		    }
		   
		 
}
