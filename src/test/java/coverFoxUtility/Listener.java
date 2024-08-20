package coverFoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.Base;

public class Listener extends Base implements ITestListener {
	
	 @Override
	public void onTestStart(ITestResult result) {
		// result.getName(); gives name of test case
		Reporter.log("Test Case "+result.getName()+" execution started",true);
	}
	 
	 @Override
	public void onTestSuccess(ITestResult result) {
			Reporter.log("Test Case "+result.getName()+" executed successfully",true);

	}
	 
	 @Override
	public void onTestFailure(ITestResult result) {
			Reporter.log("Test Case "+result.getName()+" failed",true);
			try {
				Utility.takeScreenShot(driver, result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	 
	 @Override
	public void onTestSkipped(ITestResult result) {
			Reporter.log("Test Case "+result.getName()+" is skipped",true);

	}

}
