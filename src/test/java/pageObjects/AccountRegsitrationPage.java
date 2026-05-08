package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegsitrationPage extends BasePage {

	public AccountRegsitrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPwd;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmation;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkbxPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstname(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telphn) {
		txtTelephone.sendKeys(telphn);
	}

	public void setPwd(String pwd) {
		txtPwd.sendKeys(pwd);
	}

	public void setCnfPwd(String pwd) {
		txtConfirmation.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkbxPolicy.click();

	}

	public void clickContinue() {
		// sol1
		btnContinue.click();
		;

		// sol2
		// btnContinue.submit();

		// sol3
		// Actions act=new Actions(driver);
		// act.moveToElement(btnContinue).click().perform();

		// sol4
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", btnContinue);

		// Sol 5
		// btnContinue.sendKeys(Keys.RETURN);

		// Sol6
		// WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}

	public String getConfirmationmsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
