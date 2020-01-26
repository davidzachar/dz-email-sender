package com.email.sender.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSender {

	@GetMapping("/test")
	public String test() {
		return "Working";
	}
	
}
