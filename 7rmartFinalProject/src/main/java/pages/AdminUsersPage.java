package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage
{
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(name="username")private WebElement usernamefield;
	@FindBy(name="password")private WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']")private WebElement signinfield;
	@FindBy(xpath="//a[@class='small-box-footer']")private WebElement AdminUsers;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newadminuser;
	@FindBy(xpath="//input[@id='username']")private WebElement adminusername;
	@FindBy(xpath="//input[@id='password']")private WebElement adminpassword;
	@FindBy(xpath="//select[@id='user_type']")private WebElement adminusertype;
	@FindBy(xpath="//button[@name='Create']")private WebElement newadminsavebutton;
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchadminuser;
	@FindBy(xpath="//input[@id='un']")private WebElement searchadminusername;
	@FindBy(xpath="//select[@id='ut']")private WebElement searchadminuseretype;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchbutton;

	@FindBy(xpath="//input[@id='un']")private WebElement searchadminuserbutton;



	public void enterUesrnameOnUserNameField(String username)
	{
		usernamefield.sendKeys(username);


	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);


	}
	public void clickLoginButtonField()
	{
		signinfield.click();


	}
	public void clickAdminUsersField()
	{
		AdminUsers.click();
		
	}
	public void clickAddNewAdminUserField()
	{
	newadminuser.click();
		
	}
	public void enterNewAdminUserUsername(String newadminuser)
	{
	adminusername.sendKeys(newadminuser);
		
	}
	public void enterNewAdminUserPassword(String newadminpassword)
	{
	adminpassword.sendKeys(newadminpassword);
		
	}
	public void selectNewAdminUserType( )
	{
		Select select=new Select(adminusertype);
		select.selectByIndex(1);
	}
	public void clickSaveNewAdminUserField()
	{
		newadminsavebutton.click();
		
	}
	public void clickSearchAdminUserField()
	{
		searchadminuser.click();
		
	}
	public void enterSearchAdminUsername(String testadminuser)
	{
		
		searchadminusername.sendKeys(testadminuser);
	}
	public void selectSearchAdminUserType()
	{
		
		searchadminuseretype.click();
	}
	public void clickSearchAdminUserButton()
	{
		
		searchbutton.click();
	}
	
}
