package com.capstone.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.capstone.WebUtils;
import com.capstone.capstone.model.Users;
import com.capstone.capstone.repository.UserRepository;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	WebUtils webUtils;
	
	@GetMapping("index")
	//@ResponseBody
	public String index(Model model) {
		model.addAttribute("msg", "Hello There...General Kenobi");
		model.addAttribute("alldb", userRepository.findAll());
		return "index";
	}
	
	@GetMapping("about")
	//@ResponseBody
	public String about(Model model) {
		model.addAttribute("aboutme", "I killed them all. Not just the men, but the women and the children too.");
		return "about";
	}
	
	@GetMapping({"services", "/"})
	//@ResponseBody
	public String services(Model model) {
		model.addAttribute("podracing", "Now THIS is podracing!");
		return "services";
	}
	
	@GetMapping("name")
	//@ResponseBody
	public String name(@RequestParam String id,Model model) {
		index(model);
		model.addAttribute("myname", id);
		return "index";
	}
	
	@GetMapping("getname-{id}")
	//@ResponseBody
	public String getname(@PathVariable String id,Model model) {
		model.addAttribute("getname", id);
		return "index";
	}
	
	@PostMapping("sendemail")
	public String sendemail(Model model, @RequestParam String email, @RequestParam String name, @RequestParam String subject, @RequestParam String message) {
		webUtils.sendMail(email, message, subject + " - " + name);
		model.addAttribute("msg", "Email Sent!");
		return "services";
	}
	
//	@PostMapping("login")
//	//@ResponseBody
//	public String login(@RequestParam String fname, @RequestParam String lname, Model model) {
//		model.addAttribute("name", "First Name: " + fname +"<br>Last Name: "+lname);
//		return "index";
//	}
	

	@ModelAttribute("user")
	Users user() {
		return new Users();
	}
}
