package com.codingdojo.dojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.services.DojoService;



@Controller
public class DojosController {
	private final DojoService dojoService;
    
    public DojosController (DojoService dojoService) {
        this.dojoService = dojoService;
    }
    
    @RequestMapping("/dojos")
    public String index(Model model,@ModelAttribute("form") Dojo dojos) {
    
        return "newDojo.jsp";
    }
    
	
	
	
	   @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("form") Dojo dojo, BindingResult result) {
	        if (result.hasErrors()) {
	            return "newDojo.jsp";
	        } else {
	            dojoService.createDojo(dojo);
	            return "redirect:/dojos";
	        }
	    }
	   
	   @RequestMapping("/show/{id}")
	   public String show(@PathVariable("id") Long id, Model model) {
		   Dojo dojo= dojoService.findDojo(id);
		   model.addAttribute("dojo", dojo);
		   
		   return "show.jsp";
		   
		   
	   }
}
