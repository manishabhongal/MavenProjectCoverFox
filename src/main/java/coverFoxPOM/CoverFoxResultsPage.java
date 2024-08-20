package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultsPage {
	// Data Members --->WebElements

		@FindBy(xpath = "//div[contains(text(),' Insurance Plans')]")
		private WebElement insurancePlanText;

		@FindBy(xpath = "//div[@class='plan-card-container']")
		private List<WebElement> banners;

		@FindBy(className = "f-select__handle")
		private WebElement filterDropdown;

		// constructor
		public CoverFoxResultsPage(WebDriver driver) {

			PageFactory.initElements(driver, this);
		}

		public void validateBannersSize() {
			Reporter.log("getting planNumber from string",true);

			String[] ar = insurancePlanText.getText().split(" ");
			int result = Integer.parseInt(ar[0]);// actual number
			Reporter.log("getting planNumber from string",true);

			if (result == banners.size()) {
				System.out.println("Result is matching TC is passed");
			} else {
				System.out.println("Result is not matching TC is failed");
			}

		}

		// plan numbers from string
		public int getPlanNumbersFromString() {
			Reporter.log("getting planNumber from string",true);

			String[] ar = insurancePlanText.getText().split(" ");
			int result = Integer.parseInt(ar[0]);
			return result;
		}

		// plan numbers from banners
		public int getPlanNumbersFromBanners() {
			Reporter.log("getting planNumber From Banners",true);

			int totalBanners = banners.size();
			return totalBanners;

		}

		public boolean verifyFilterDropdownIsDisplayed() {
			Reporter.log("verifying FilterDropdown IsDisplayed",true);

			boolean result = filterDropdown.isDisplayed();
			return result;

		}

}
