package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage

{
	WaitUtility wait=new WaitUtility();
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinfield;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement visiblealert;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='login-logo']")
	private WebElement logintext;

	public LoginPage enterUesrnameOnUserNameField(String username) {//for clicking username no page redirection so passing login class in place of return type
		usernamefield.sendKeys(username);
return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
return this;
	}

	public HomePage clickLoginButtonField() {// here returning to home page 
		wait.waitUntilClickable(driver, signinfield);
		signinfield.click();
		return new HomePage(driver);
	}

	public boolean alertVisibility() {
		return visiblealert.isDisplayed();
	}

	public String getDashboardText() {

		return dashboard.getText();
	}

	public String getLoginPageText() {

		return logintext.getText();
	}

}
