/*
 This is the Geb configuration file.
 
 See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { new ChromeDriver() }
//baseUrl = "http://localhost:8080/bdd-demo/"
environments {
 
 // run as “mvn -Dgeb.env=chrome test”
 // See: http://code.google.com/p/selenium/wiki/ChromeDriver
 build-chrome {
		 driver = { new FirefoxDriver() }
		 baseUrl = "http://my-build-server:8080/bdd-demo/"
 }

}