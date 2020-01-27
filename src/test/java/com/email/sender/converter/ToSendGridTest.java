package com.email.sender.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.email.sender.api.request.SendRequest;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Personalization;

public class ToSendGridTest {
	
	@Test
	public void testConvert() {
		SendRequest req = new SendRequest();
		req.setFrom("a@a.a");
		req.setTo("b@b.b,c@c.c, d@d.d ");
		req.setCc(" e@e.e , f@f.f");
		req.setBcc(" q@q.q ");
		req.setSubject("test");
		req.setBody("body");
		
		Mail m = ToSendGrid.convert(req);
		
		assertEquals("a@a.a", m.getFrom().getEmail());
		assertEquals(1, m.getPersonalization().size());
		Personalization p = m.getPersonalization().get(0);
		
		assertEquals(3, p.getTos().size());
		assertTrue(p.getTos().stream().filter(e -> "b@b.b".equals(e.getEmail())).findAny().isPresent());
		assertTrue(p.getTos().stream().filter(e -> "c@c.c".equals(e.getEmail())).findAny().isPresent());
		assertTrue(p.getTos().stream().filter(e -> "d@d.d".equals(e.getEmail())).findAny().isPresent());

		assertEquals(2, p.getCcs().size());
		assertTrue(p.getCcs().stream().filter(e -> "e@e.e".equals(e.getEmail())).findAny().isPresent());
		assertTrue(p.getCcs().stream().filter(e -> "f@f.f".equals(e.getEmail())).findAny().isPresent());
		
		assertEquals(1, p.getBccs().size());
		assertTrue(p.getBccs().stream().filter(e -> "q@q.q".equals(e.getEmail())).findAny().isPresent());
		
		assertEquals("test", m.getSubject());
		assertEquals("text/plain", m.getContent().get(0).getType());
		assertEquals("body", m.getContent().get(0).getValue());
		
	}

}
