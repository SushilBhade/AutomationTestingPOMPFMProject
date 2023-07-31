package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.RegisterPage;

public class RegisterTest {

	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
	}

	@Test
	public void register() {
		RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName("Amol");
		registerPage.enterLastName("abc");
		registerPage.enterAddress("pune");
		registerPage.enterEmail("kiran@gmail.com");
		registerPage.enterPhone("1234567890");
		registerPage.selectGender("male");
		List<String> hobbies=new ArrayList<String>();
		hobbies.add("Cricket");
		hobbies.add("Movies");
		registerPage.selectHobbies(hobbies);
		registerPage.selectSkills("Adobe Photoshop");
		//registerPage.selectCountry("India");
		RegisterPage languages=new RegisterPage(driver);
		languages.selectLanguage("English");
		languages.selectLanguage("German");
		languages.selectLanguage("French");
		 registerPage.selectLanguage("English");
	
	}
}
