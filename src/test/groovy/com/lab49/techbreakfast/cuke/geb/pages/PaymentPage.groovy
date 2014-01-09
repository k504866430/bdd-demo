package com.lab49.techbreakfast.cuke.geb.pages

import geb.Page
import groovy.lang.MetaClass;

class PaymentPage extends Page {
	static url = "payment"
	static at = {title == "Payment"}
	
	static content = {
		paymentDropdown { $('select', name: "PaymentOption") }
		paymentDropdownOptions { paymentDropdown.find('option').collect{it.text()} }
		creditCardTypeDropdown(wait: true) { $('select', name: "CardType") }
		creditCardNumber(wait: true) { $('input', name: "CardNumber") }
		billingAddress { $('input', name: "BillingAddress") }
		errorText { $('div#card_number_error').text() }
	}
	
}
