package Test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Register {
 static	WebDriver driver;
         Action act;
	Select select;
	//public class LoginTest /*extends BaseClass*/ {

	@BeforeMethod
	public void setup() {
if(driver==null) {
		driver=new ChromeDriver();
	//	driver=new FirefoxDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
	}
}

//	@Test
//	public void registerFullName() {
//		List<WebElement> first=driver.findElements(By.xpath("//input[@type='text']"));
//		selectT
//	}
//	public void enterTextFullName(List<WebElement> first,String FullName) {
//		for(WebElement text: texts ) {
//		}
//	}

	@Test(priority=1)
	public void registerRadioButton() {
		List<WebElement> radios=driver.findElements(By.xpath("//input[@name='radiooptions']"));

		selectRadio(radios,"FeMale");
	}

	public void selectRadio(List<WebElement> radios,String gender) {
		for(WebElement radio: radios) {

			if(radio.getAttribute("value").equals(gender)) {
				radio.click();
				break;
			}
		}
	}

	@Test(priority=2)
	public void registerDropdownSkills() {
		WebElement skills=driver.findElement(By.id("Skills"));
		select=new Select(skills);
		select.selectByVisibleText("APIs");
	}
	public void selectByVisibleText(WebElement elem,String option) {
		Select dropdown=new Select(elem);
		try {
			dropdown.selectByVisibleText(option);
		} catch (Exception e) {
			System.out.println("no such element found");
		}
	}

	@Test(priority=3)
	public void registerCheckBoxHobbies() {
		List<String>hobbies=new ArrayList<String>();
		hobbies.add("Cricket");
		hobbies.add("Movies");
		
		List<WebElement>elems=driver.findElements(By.xpath("//input[@type='checkbox']"));
		selectCheckBox(elems,hobbies);
	}
	public void selectCheckBox(List<WebElement> elems,List<String> hobbies) {
		for (String hobbie : hobbies) {
			for(WebElement elem : elems) {
				if(elem.getAttribute("value").equals(hobbie)) {
					elem.click();
					break;
				}
			}
		}	
	}
	@Test(priority=4)
//	public void registerDropdownLanguage() {
//		List<String> languages=new ArrayList<String>();
//		languages.add("English");languages.add("Hindi");languages.add("Arabic");
//		
//		List<WebElement> elem=driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
//		multiSelect(elem,languages);
//	}
//	public void multiSelect(List<WebElement> element,List<String> languages){
//		for( String language : languages){
//			for(WebElement lang :element ) {
//				if(lang.getAttribute("style").equals(language)){
//					lang.click();
//					break;
//				}
//			}
//		}
//	}
	public void registerLanguageDropdown() {
		 WebElement multiSelectElement = driver.findElement(By.id("msdd"));
		 multiSelectElement.click();
		 WebElement languageOption = driver.findElement(By.xpath("//a[contains(text(),'Arabic')]"));
		 WebElement languageOption1 = driver.findElement(By.xpath("//a[contains(text(),'Hindi')]"));
		 WebElement languageOption2 = driver.findElement(By.xpath("//a[contains(text(),'English')]"));
		 
	        languageOption.click();
	        languageOption1.click();
	        languageOption2.click();
	        languageOption.click();
	        
	        WebElement pageBody = driver.findElement(By.xpath("//body"));
	        pageBody.click();
	}
	
	
	
	@Test(enabled=false)
	 public void registerLanguageDropdown2() {
        String dropdownId = "msdd";
        String optionsXPath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//a";

        selectFromMultiSelectDropdown(driver, dropdownId, optionsXPath, "English");
        selectFromMultiSelectDropdown(driver, dropdownId, optionsXPath, "German");
    }
	
	public static void selectFromMultiSelectDropdown(WebDriver driver, String dropdownId, String optionsXPath, String optionToSelect) {
	        WebElement dropdownElement = driver.findElement(By.id(dropdownId));
	        dropdownElement.click(); // Open the dropdown to display options

	        List<WebElement> options = driver.findElements(By.xpath(optionsXPath));
	        for (WebElement option : options) {
	            if (option.getText().equalsIgnoreCase(optionToSelect)) {
	                option.click(); // Click on the desired option
	                break;
	            }
	        }
	        dropdownElement.click(); // Close the dropdown after selection (optional)
	    }
	}
	

