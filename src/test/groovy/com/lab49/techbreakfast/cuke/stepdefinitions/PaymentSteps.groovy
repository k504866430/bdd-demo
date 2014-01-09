package com.lab49.techbreakfast.cuke.stepdefinitions
import java.beans.Introspector;

import com.lab49.techbreakfast.cuke.geb.pages.PaymentPage;

import cucumber.api.PendingException

// Add functions to register hooks and steps to this script.
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(geb.Browser)

When(~'^I visit the "([^"]*)" page$') { String arg1 ->
	to PaymentPage
	verifyAt()
}

Then(~'^I should be able to select "([^"]*)" from payment options$') { String optionValue ->
	assert optionValue in paymentDropdownOptions
}

When(~'^I select "([^"]*)" from payment options$') { String optionValue ->
	paymentDropdown = optionValue
	assert paymentDropdown == optionValue
}

Then(~'^I should be able to select "([^"]*)"$') { String optionDropdown ->
	sanitized = Introspector.decapitalize(optionDropdown.replaceAll(" ", ""))
	assert browser."${sanitized}Dropdown" != null
}


Then(~'^I should be able to input "([^"]*)"$') { String inputName ->
	// Express the Regexp above with the code you wish you had
	sanitized = Introspector.decapitalize(inputName.replaceAll(" ", ""))
	browser."${sanitized}" = "Some Number"
	assert browser."${sanitized}" == "Some Number"
}

Given(~'^I have selected "([^"]*)" from payment options$') { String optionValue ->
	paymentDropdown = optionValue
}

When(~'^I select "([^"]*)" "([^"]*)"$') { String optionValue, String optionDropdown ->
	sanitized = Introspector.decapitalize(optionDropdown.replaceAll(" ", ""))
	browser."${sanitized}Dropdown" = optionValue
}

When(~'^I input "([^"]*)" "([^"]*)"$') { String inputValue, String inputName ->
	sanitized = Introspector.decapitalize(inputName.replaceAll(" ", ""))
	browser."${sanitized}" = inputValue
}

Then(~'^I should see "([^"]*)" message$') { String arg1 ->
	assert errorText == "Incorrect Format"
}

Then(~'^I should not see "([^"]*)" message$') { String arg1 ->
	// Express the Regexp above with the code you wish you had
	throw new PendingException()
}

When(~'^I click "([^"]*)"$') { String arg1 ->
	// Express the Regexp above with the code you wish you had
	throw new PendingException()
}