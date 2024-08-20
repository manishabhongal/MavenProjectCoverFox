package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	

		// data Members--->WebElements

		@FindBy(xpath = "//div[text()='Female']")
		private WebElement femaleButton;

		// Constructor--->use to initialize non static global variables

		// we have initElements static method to initialize data members in PageFactory
		// class

		public CoverFoxHomePage(WebDriver driver) {

			PageFactory.initElements(driver, this); // to control the webpage we need driver object so parameterize  the constructor
															//here we use this keyword to access the global variables in local loop
		}

		// methods
		
		public void clickOnFemaleButton() {
			Reporter.log("clicking on female button on homepage", true);
			
			femaleButton.click();
		}
}
