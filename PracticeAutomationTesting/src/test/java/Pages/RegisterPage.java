package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
WebDriver driver;
	public RegisterPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
	WebElement firstName;

	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
	WebElement lastName;

	@FindBy(xpath="//*[@id=\"eid\"]/input")
	WebElement email;

	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")
	WebElement phone;

	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[2]/div/textarea")
	WebElement address;

	@FindBy(name="radiooptions")
	List<WebElement> genders;

	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> hobbies;

	@FindBy(id="Skills")
	WebElement skills;

	@FindBy(xpath="//*[@id=\"select2-country-container\"]")
	WebElement country;
	//*[@id="select2-country-container"]	

	//@FindBy(xpath = "//li[contains(@class, 'ng-scope')]/a")
	//List<WebElement> languageElements;
	
	@FindBy(xpath = "//div[@id='msdd']")
	     WebElement customDropdown;

	  
	//-------------------------------------------------------------------------------	 
	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}
	public void enterLastName(String namel) {
		lastName.sendKeys(namel);
	}

	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void enterPhone(String phone) {
		this.phone.sendKeys(phone);
	}

	public void enterAddress(String address) {
		this.address.sendKeys(address);
	}
	public void selectGender(String userInput) {
		for(WebElement gender: genders) {
			if(gender.getAttribute("value").equalsIgnoreCase(userInput));
			gender.click();
			break;
		}
	}
	public void selectHobbies(List<String> userInput) {
		for(String input: userInput) {
			for (WebElement hobbie:hobbies) {
				if(hobbie.getAttribute("value").equalsIgnoreCase(input)) {
					hobbie.click();
					break;
				}
			}
		}
	}
	public void selectSkills(String input ) {
		Select select=new Select(skills);
		select.selectByVisibleText(input);
	}

//	public void selectCountry(String inputcountry ) {
//		Select select=new Select(country);
//		select.selectByVisibleText(inputcountry);
//	}

//	public void selectLanguages(List<String> languageNames) {
//		for (String languageName : languageNames) {
//			for (WebElement language : languages) {
//				if (language.getText().trim().equalsIgnoreCase(languageName)) {
//					language.click();
//					break;
//				}
//			}
//		}
//	}
//	 public void selectLanguage(String language) {
//	        for (WebElement element : languageElements) {
//	            String languageText = element.getText().trim();
//	            if (languageText.equalsIgnoreCase(language)) {
//	                element.click();
//	                break;
//	            }
//	        }
//	    }
//	  public void selectLanguage(String... languages) {
//	        customDropdown.click(); // Open the custom dropdown
//
//	        
//			WebElement languageOption = driver.findElement(By.xpath("//a[contains(text(),'" + languages + "')]"));
//	        languageOption.click(); // Select the desired option
//
//}

	  public void selectLanguage(String... languages) {
		    customDropdown.click(); // Open the custom dropdown
		    for (String language : languages) {
		        WebElement languageOption = driver.findElement(By.xpath("//a[contains(text(),'" + language + "')]"));
		        languageOption.click(); // Select the desired option
		    
		    }
		}

}
