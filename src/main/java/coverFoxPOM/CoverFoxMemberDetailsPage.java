package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {
	//WebElements--->data members
	
		@FindBy(name = "You") private WebElement ageDropDown;
		@FindBy(className = "next-btn") private WebElement nextButton;
		
		
		
		//constructor
		
		public CoverFoxMemberDetailsPage( WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//methods
		
		public void clickOnAgeDropDown(String age) {
			Reporter.log("Handleing ageDropDown", true);
			Select s=new Select(ageDropDown);
			s.selectByValue(age+"y");
			
		}
		
		public void clickOnNextButton() {
			Reporter.log("clicking on next button of MemberDetailsPage", true);
			nextButton.click();

		}

}
