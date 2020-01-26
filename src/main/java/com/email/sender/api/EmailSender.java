package com.email.sender.api;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.sender.api.request.SendRequest;

@Validated
@RestController
public class EmailSender {

	@GetMapping("/test")
	public String test() {
		return "Working";
	}
	
	@PostMapping("/send")
	public String send(@Valid @RequestBody SendRequest request) {
		return "Whatever";
	}
	
}
