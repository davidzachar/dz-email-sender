package com.email.sender.converter;

import java.util.ArrayList;
import java.util.List;

import com.email.sender.api.request.SendRequest;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class ToSendGrid {
	
	public static Mail convert(SendRequest req) {
		Content content = new Content("text/plain", req.getBody());
		Mail mail = new Mail();
		mail.setFrom(new Email(req.getFrom()));
		mail.setSubject(req.getSubject());
	    Personalization personalization = createPersonalization(req);
	    mail.addPersonalization(personalization);
	    mail.addContent(content);
        return mail;
	}
	
	private static Personalization createPersonalization(SendRequest req) {
		Personalization personalization = new Personalization();
		convertToEmails(req.getTo()).stream().forEach(e -> personalization.addTo(e));
		convertToEmails(req.getCc()).stream().forEach(e -> personalization.addCc(e));
		convertToEmails(req.getBcc()).stream().forEach(e -> personalization.addBcc(e));
		return personalization;
	}
	
	private static List<Email> convertToEmails(String emails) {
		List<Email> list = new ArrayList<>();
		if (emails == null || emails.isEmpty())
			return list;
		if (emails.contains(",")) {
			for (String email : emails.split(",")) {
				if (!email.trim().isEmpty())
					list.add(new Email(email.trim()));
			}
		} else {
			list.add(new Email(emails));
		}
		return list;
	}

}
