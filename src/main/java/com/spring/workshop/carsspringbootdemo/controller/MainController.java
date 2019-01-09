package com.spring.workshop.carsspringbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping({"/", "/welcome"})
	public String showWelcomePage() {
		return "welcome";
	}

}
