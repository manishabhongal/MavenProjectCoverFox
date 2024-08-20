package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
	// WebElements--->data members
		@FindBy(className = "mp-input-text")
		private WebElement pincode;
		@FindBy(id = "want-expert")
		private WebElement mobileNumber;
		@FindBy(xpath = "//div[text()=' Please enter a valid pincode ']")
		private WebElement pinCodeError;
		@FindBy(xpath = "//div[text()=' Please enter a valid mobile no. ']")
		private WebElement mobileNoError;
		@FindBy(className = "next-btn")
		private WebElement continueButton;

		// constructor
		public CoverFoxAddressDetailsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// methods
		public void enterPincode(String pincodeValue) {
			Reporter.log("Entering pinCode",true);
			pincode.sendKeys(pincodeValue);
		}

		public void enterMobileNumber(String mobileNumberValue) {
			Reporter.log("Entering mobileNumber",true);

			mobileNumber.sendKeys(mobileNumberValue);
		}

		// newly added methods
		public void enterInvalidPinCode(String pincodeValue) {
			Reporter.log("Entering invalid pinCode",true);

			pincode.sendKeys(pincodeValue);
		}

		public String getPinErrorMsg() {
			Reporter.log("getting errorPinMsg",true);

			String errorMessageForPinCode = pinCodeError.getText();
			return errorMessageForPinCode;
	}

		public void enterInvalidMobileNumber(String mobileNumberValue) {
			Reporter.log("Entering invalid mobileNumber",true);

			mobileNumber.sendKeys(mobileNumberValue);
		}

		public String getMobileErrorMsg() {
			Reporter.log("getting errorMobNumMsg",true);

			String errorrMessageForMobNo = mobileNoError.getText();
			return errorrMessageForMobNo;
		}
		
		public String getPinErrorMsgColor() {
			Reporter.log("getting colorOfPinErrorMsg",true);
			String colorOfPinErrorMsg = pinCodeError.getCssValue("color");
			String hexFormatcolorOfPinErrorMsg = Color.fromString(colorOfPinErrorMsg).asHex();
			return hexFormatcolorOfPinErrorMsg;
		}

		public void clickOnContinueButton() {
			
			Reporter.log("clicking on continue button on addressDetails page",true);

			continueButton.click();
		}


}
