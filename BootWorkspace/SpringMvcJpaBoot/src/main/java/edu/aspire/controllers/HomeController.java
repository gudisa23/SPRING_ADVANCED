package edu.aspire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.aspire.entities.UserRepository;

@Controller
public class HomeController {
	static{
		System.out.println("***HomeController***");
	}
	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/")
	public String home(Model model){
		System.out.println("***home***");
		model.addAttribute("users", userRepo.findAll());
		return "index";
	}
}
