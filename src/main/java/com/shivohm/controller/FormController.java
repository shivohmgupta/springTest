package com.shivohm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shivohm.model.Customer;

@Controller
public class FormController {

	 Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Login() {
		return "index";
	}
	 
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String customerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String customerSubmit(@ModelAttribute Customer customer, Model model) {

		model.addAttribute("customer", customer);
		String info = String.format("Customer Submission: id = %d, firstname = %s, lastname = %s", customer.getId(),
				customer.getFirstname(), customer.getLastname());
		log.info(info);

		return "result";
	}

}
