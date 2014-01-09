describe("Credit Card", function(){
	it("should clean the numbers by removing spaces and hyphens",  function(){
		expect(CreditCard.cleanNumber("1-2 345")).toEqual("12345");
	});
	it("should pass luhn test", function(){
		expect(CreditCard.validNumber("4111 1111 1111-1111")).toBeTruthy()
		expect(CreditCard.validNumber("4111 1111 1111-1121")).toBeFalsy()
	});
	it("should validate when text field looses focus", function(){
		loadFixtures("credit_card_form.html");
		$("#card_number").validateCreditCardNumber();
		$("#card_number").val("112");
		$("#card_number").blur();
		expect($("#card_number_error")).toHaveText("Invalid credit card number");
		
		$("#card_number").val("4111 1111 1111-1111");
		$("#card_number").blur();
		expect($("#card_number_error")).toHaveText("");
	});
});