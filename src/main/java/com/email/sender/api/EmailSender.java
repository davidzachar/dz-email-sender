package com.email.sender.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailSender {

	@GetMapping("/test")
	public String test() {
		return "Working";
	}
	
}
