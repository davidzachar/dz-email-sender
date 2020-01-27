package com.email.sender.api;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.sender.api.request.SendRequest;
import com.email.sender.converter.ToSendGrid;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;

@Validated
@RestController
public class EmailSender {
	
	@Autowired
	SendGrid sendGrid;

	@GetMapping("/test")
	public String test() {
		return "Working";
	}
	
	@PostMapping("/send")
	public Response send(@Valid @RequestBody SendRequest req) {
		Mail mail = ToSendGrid.convert(req);
        Request sgRequest = new Request();
        Response sgResponse = null;
        try {
        	sgRequest.setMethod(Method.POST);
        	sgRequest.setEndpoint("mail/send");
        	sgRequest.setBody(mail.build());
            sgResponse = sendGrid.api(sgRequest);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sgResponse;
	}
	
}
