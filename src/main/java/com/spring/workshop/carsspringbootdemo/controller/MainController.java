package com.spring.workshop.carsspringbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.workshop.carsspringbootdemo.model.User;
import com.spring.workshop.carsspringbootdemo.service.SecurityService;
import com.spring.workshop.carsspringbootdemo.service.UserService;
import com.spring.workshop.carsspringbootdemo.validator.UserValidator;

@Controller
public class MainController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping({"/", "/welcome"})
	public String showWelcomePage() {
		return "welcome";
	}
	
	@GetMapping("/registration")
	public String showRegistrationPage(ModelMap model) {
		model.put("userForm", new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String createUserAccount(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, ModelMap model) {
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(userForm);
		
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		
		return "redirect:/welcome";
	}
	
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin";
	}
	
	@GetMapping("/login")
    public String login(ModelMap model, String error, String logout) {
        if (error != null)
            model.put("error", "Your username and password is invalid.");

        if (logout != null)
            model.put("message", "You have been logged out successfully.");

        return "login";
    }
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login?logout";
	}

}
