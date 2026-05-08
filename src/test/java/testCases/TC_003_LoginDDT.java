package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

	public void loginDDT(String email, String pwd, String extd) {
		logger.info("**** Starting TC_003_LoginDDT *****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPwd(pwd);
			lp.clickLogin();

			MyAccountPage myAcc = new MyAccountPage(driver);
			boolean targetpage = myAcc.isMyAccountPageExist();

			/*
			 * Data is valid - login success - test pass - logout Data is valid -- login
			 * failed - test fail
			 * 
			 * Data is invalid - login success - test fail - logout Data is invalid -- login
			 * failed - test pass
			 */

			if (extd.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}

			if (extd.equalsIgnoreCase("Invalid")) {
				if (targetpage == false) {
					Assert.assertTrue(true);
				} else {
					myAcc.clickLogout();
					Assert.assertTrue(false);
				}
			}

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("**** Finished TC_003_LoginDDT *****");
	}
}
