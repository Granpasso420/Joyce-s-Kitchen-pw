package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contatti")
public class contattiController {
	
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("title","Contatti");
		return "contatti";
	}
}
