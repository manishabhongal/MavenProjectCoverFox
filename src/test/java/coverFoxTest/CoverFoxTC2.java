package coverFoxTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultsPage;
import coverFoxUtility.Utility;



public class CoverFoxTC2 extends Base{
	// first declare all the objects globally so that later they can be accessible.
	//here no need to declare and initialize driver here because we have already initialized driver in BASE class and in test class we have extended that base class.
		CoverFoxHomePage homePage;
		CoverFoxHealthPlanPage healthPlanPage;
		CoverFoxMemberDetailsPage memberPage;
		CoverFoxAddressDetailsPage addressPage;
		CoverFoxResultsPage resultsPage;
		//String filePath;

		@BeforeTest
		public void launchBrowser() throws EncryptedDocumentException, IOException {
			openBrowser();
			// now initialize all the objects
			homePage = new CoverFoxHomePage(driver);  // initialize obj in method always
			healthPlanPage = new CoverFoxHealthPlanPage(driver);
			memberPage = new CoverFoxMemberDetailsPage(driver);
			addressPage = new CoverFoxAddressDetailsPage(driver);
			resultsPage = new CoverFoxResultsPage(driver);
			//filePath = "D:\\Excel Files\\excelTest1.xlsx"; // excel file path

		}

		@BeforeClass
		public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException {
			// common steps
			homePage.clickOnFemaleButton();
			Thread.sleep(1000);
			healthPlanPage.clickOnNextButton();
			Thread.sleep(1000);
			memberPage.clickOnAgeDropDown(Utility.readDataFromExcel("excelTest1", "Sheet3", 1, 0));
			memberPage.clickOnNextButton();
			Thread.sleep(1000);

			addressPage.enterInvalidPinCode(Utility.readDataFromExcel("excelTest1", "Sheet3", 1, 1));
			addressPage.enterInvalidMobileNumber(Utility.readDataFromExcel("excelTest1", "Sheet3", 1, 2));
			Thread.sleep(2000);

			addressPage.clickOnContinueButton();
			Thread.sleep(4000);

		}

		@Test
		public void validatePinCodeErrorMessage() throws IOException  {
          //   Assert.fail();
			String actualPinCodeErrorMsg = addressPage.getPinErrorMsg();
			String expectedPinCodeErrorMsg = "Please enter a valid pincode";
			Assert.assertEquals(actualPinCodeErrorMsg, expectedPinCodeErrorMsg,"Validation error message for PinCode field is not matching,TC is failed");
			//Utility.takeScreenShot(driver, "validatePinCodeErrorMessage");
		}

		@Test
		public void validateMobileNumberErrorMessage() {

			String actualMobileNoErrorMsg = addressPage.getMobileErrorMsg();
			String expectedMobileNoErrorMsg = "Please enter a valid mobile no.";
			Assert.assertEquals(actualMobileNoErrorMsg, expectedMobileNoErrorMsg,"Validation error message for Mobile Number field is not matching,TC is failed");
		}

		
		
		
		public void validatePinCodeErrorMsgColor() {
			
			
			
		}
		
		@Test
		public void validateMobileNoErrorMsgColor() {
			
			String actualColorOfPinErrorMsg = addressPage.getPinErrorMsgColor();
			String expectedColorOfPinErrorMsg = "#ec5f67";  //hex format of red color
			Assert.assertEquals(actualColorOfPinErrorMsg, expectedColorOfPinErrorMsg,"Color of validation error msg is not matching");
			
		}
		@AfterClass
		public void closeBrowser() throws InterruptedException {

			browserClose();
		}

}
