package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Master","Regression"})
	public void verify_login() {

		logger.info("***** TC_002_LoginTest started *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPwd(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage myAccp = new MyAccountPage(driver);
			boolean targetpage = myAccp.isMyAccountPageExist();
			Assert.assertTrue(targetpage); // Assert.assertEquals(targetpage, true, "Login Failed...");
		} catch (Exception e) {
			Assert.fail();

		}

		logger.info("***** TC_002_LoginTest completed *****");
	}

}
