package com.magno.modelo.services;

import org.springframework.mail.SimpleMailMessage;

import com.magno.modelo.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
