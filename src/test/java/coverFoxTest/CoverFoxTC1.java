package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

//@Listeners(coverFoxUtility.Listener.class)
public class CoverFoxTC1 extends Base {

	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxMemberDetailsPage memberPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxResultsPage resultsPage;
	String filePath;
	public static Logger logger;

	@BeforeTest
	public void launchBrowser() {
		
		logger=Logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("Log4j.properties");

		logger.info("Opening browser");
		openBrowser();

		homePage = new CoverFoxHomePage(driver); 

		healthPlanPage = new CoverFoxHealthPlanPage(driver);

		memberPage = new CoverFoxMemberDetailsPage(driver);

		addressDetailsPage = new CoverFoxAddressDetailsPage(driver);

		resultsPage = new CoverFoxResultsPage(driver);

		//filePath = System.getProperty("user.dir")+"\\excelTest1.xlsx";

	}

	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException {
		logger.info("Clicking on female button");
		homePage.clickOnFemaleButton();
		Thread.sleep(1000);
		logger.info("Clicking on next button");

		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);
		//memberPage.clickOnAgeDropDown(Utility.readDataFromPropertiesFile("age"));
		logger.warn("Age should be between 18-90");
		logger.info("selecting age from age drop down");

		memberPage.clickOnAgeDropDown(Utility.readDataFromExcel("excelTest1", "Sheet3", 0, 0));

		logger.info("Clicking on next button");

		memberPage.clickOnNextButton();
		Thread.sleep(1000);
		//addressDetailsPage.enterPincode(Utility.readDataFromPropertiesFile("pinCode"));
		logger.warn("Please enter the valid pin code");
		logger.info("Entering pin code");

		addressDetailsPage.enterPincode(Utility.readDataFromExcel("excelTest1", "Sheet3", 0, 1));

	//	addressDetailsPage.enterMobileNumber(Utility.readDataFromPropertiesFile("mobileNum"));
		logger.warn("Please enter the valid mobile number");
		logger.info("Entering mobile number");

		addressDetailsPage.enterMobileNumber(Utility.readDataFromExcel("excelTest1", "Sheet3", 0, 2));
		logger.info("Clicking on continue button");

		addressDetailsPage.clickOnContinueButton();

	}

	@Test
	public void validateBanners() throws InterruptedException {

		Thread.sleep(4000);
		//Assert.fail();
		logger.info("Validating banners");

		int stringPlanNumbers = resultsPage.getPlanNumbersFromString(); // actual
		int bannerPlanNumbers = resultsPage.getPlanNumbersFromBanners(); // expected
		Assert.assertEquals(stringPlanNumbers, bannerPlanNumbers,
				"Plans on banners not matching with results,TC is failed");

	}

	@Test
	public void validatePresenceOfFilterDropdown() throws IOException, InterruptedException {
		Thread.sleep(4000);
		logger.info("Validating presence of filterDropDown");

		//Assert.fail();
		Assert.assertTrue(resultsPage.verifyFilterDropdownIsDisplayed(),
				"FilterDropdown is not displayed on result page,TC is failed");
		// Utility.takeScreenShot(driver, "validatePresenceOfFilterDropdown");
		
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		logger.info("closing browser");
		browserClose();
	}

}
