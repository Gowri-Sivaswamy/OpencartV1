package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegsitrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{

	@Test(groups= {"Master", "Sanity"})
	public void verify_Account_RegistrationTest() {
		
		logger.info("***** Starting TC_001_AccountRegistrationt****** ");
		logger.debug("This is a debug log message");
		
		try {
		
		HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clcikRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegsitrationPage regPage= new AccountRegsitrationPage(driver);
		
		logger.info("Providing customer details....");
		regPage.setFirstname(randomString().toUpperCase());
		regPage.setLastname(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regPage.setTelephone(randomNumber());

		String password=randomAlphaNumeric();
		
		regPage.setPwd(password);
		regPage.setCnfPwd(password);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("valitaing expected message....");
		
		String confmsg=regPage.getConfirmationmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("Test Passed ...");
		} 
		
		catch(Exception e) {
			logger.error("Test Failed;"+e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
	}

}
