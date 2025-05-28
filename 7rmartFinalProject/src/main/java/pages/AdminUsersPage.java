package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newadminuser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement adminusername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement adminpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement adminusertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement newadminsavebutton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchadminuser;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchadminusername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchadminuseretype;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchbutton;

	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchadminuserbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement usercreatedsuccessmessage;
	@FindBy(xpath="//span[@class='badge bg-success']")private WebElement searchfoundactiveuser;


	

	public AdminUsersPage clickAddNewAdminUserField() {
		newadminuser.click();
		return this;

	}

	public AdminUsersPage enterNewAdminUserUsername(String newadminuser) {
		adminusername.sendKeys(newadminuser);
		return this;

	}

	public AdminUsersPage enterNewAdminUserPassword(String newadminpassword) {
		adminpassword.sendKeys(newadminpassword);
		return this;

	}

	public AdminUsersPage selectNewAdminUserType() {
		Select select = new Select(adminusertype);
		select.selectByIndex(1);
		return this;
	}

	public AdminUsersPage clickSaveNewAdminUserField() {
		newadminsavebutton.click();
		return this;

	}

	public AdminUsersPage clickSearchAdminUserField() {
		searchadminuser.click();
		return this;

	}

	public AdminUsersPage enterSearchAdminUsername(String testadminuser) {

		searchadminusername.sendKeys(testadminuser);
		return this;
	}

	public AdminUsersPage selectSearchAdminUserType() {

		searchadminuseretype.click();
		return this;
	}

	public AdminUsersPage clickSearchAdminUserButton() {

		searchbutton.click();
		return this;
	}
	public boolean userCreatedValidationMessage() {

		return usercreatedsuccessmessage.isDisplayed();
	}
	public String getSearchUserActivetext() {

		return searchfoundactiveuser.getText();
	}

}
