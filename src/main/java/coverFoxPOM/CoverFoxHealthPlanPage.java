package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {
	//dataMembers-->WebElements
	
		@FindBy(className = "next-btn")private WebElement nextButton;
		
		//constructors
		
		public CoverFoxHealthPlanPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//methods
		
		public void clickOnNextButton() {
			Reporter.log("clicking on next button of health page",true);
			
			nextButton.click();
			
		}

}
