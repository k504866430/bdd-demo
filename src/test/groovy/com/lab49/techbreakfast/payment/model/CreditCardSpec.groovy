package com.lab49.techbreakfast.payment.model

import spock.lang.Specification
import spock.lang.Unroll;

class CreditCardSpec extends Specification {
	
	def "credit card number should be sanitized"(){
		expect: "spaces and hyphens to be stripped"
			new CreditCard(number).sanitize() == sanitized
		where:
			number  | sanitized
			"4 1"	| "41"
			"4-1"	| "41"
	}
	
	def "credit card number length should be valid"(){
		expect:
			new CreditCard(number, type).validateLength() == flag
		where:
			type	|	number 					| flag
			"VISA"	|	"4111111111111121"		| true
			"VISA"	|	"41111111"				| false
			"AMeX"	|	"4111111111111121"		| false
			"AMeX"	|	"411111111111111"		| true
	}
	
	def "credit card number should be validated against luhn algorithm"(){
		expect:
			new CreditCard(number).validateLuhn() == flag
		where:
			number 					| flag
			"4111111111111121"		| false
			"4111111111111111"		| true
	}
	
	def "credit card number should have valid format"(){
		expect:
			new CreditCard(number, type).isValid() == flag
		where:
			type	|	number 					| flag
			"VISA"	|	"4111 1111 1111-1121"	| false
			"VISA"	|	"4111 1111 1111 1111"	| true
	}
	
}
