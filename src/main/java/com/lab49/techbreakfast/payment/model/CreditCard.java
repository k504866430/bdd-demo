package com.lab49.techbreakfast.payment.model;

public class CreditCard {
	
	//define attributes
	
	private String cardNumber;
	private String type;
	private String sanitized;
	
	public CreditCard(String cardNumber, String type) {
		super();
		this.cardNumber = cardNumber;
		this.type = type;
		this.sanitized = cardNumber.replaceAll(" ", "").replaceAll("-", ""); 
	}

	public CreditCard(String cardNumber) {
		super();
		this.cardNumber = cardNumber;
		this.sanitized = cardNumber.replaceAll(" ", "").replaceAll("-", "");
	}
	
	public String sanitize(){
		return sanitized;
	}
	
	public boolean validateLength(){
		if(type.equals("VISA")){
			return sanitized.length() == 16;
		}else if(type.equals("AMeX")){
			return sanitized.length() == 15;
		}
		return false;
	}
	
	public boolean validateLuhn(){
		char[] charArray = sanitized.toCharArray();
		int[] number = new int[charArray.length];
		int total = 0;

		for (int i=0; i < charArray.length; i++) {
			number[i] = Character.getNumericValue(charArray[i]);
		}

		for (int i = number.length-2; i > -1; i-=2) {
			number[i] *= 2;

			if (number[i] > 9)
				number[i] -= 9;
		}

		for (int i=0; i < number.length; i++)
			total += number[i];

			if (total % 10 != 0)
				return false;

		return true; 
	}
	
	public boolean isValid(){
		return validateLength() && validateLuhn();
	}
	

}
