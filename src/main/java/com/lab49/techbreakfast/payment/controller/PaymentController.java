package com.lab49.techbreakfast.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {

	@RequestMapping("/payment")
	public String loadPaymentPage(){
		return "payment";
	}
}
