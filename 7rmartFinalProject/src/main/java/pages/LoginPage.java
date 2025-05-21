package pages;

import java.nio.file.WatchEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{
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

	public void enterUesrnameOnUserNameField(String username) {
		usernamefield.sendKeys(username);

	}

	public void enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);

	}

	public void clickLoginButtonField() {
		signinfield.click();
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
