package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkmyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkRegister;


	@FindBy (xpath = "//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		lnkmyAccount.click();
	}

	public void clcikRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}

}
