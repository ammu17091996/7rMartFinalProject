package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage

{
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(name="username")private WebElement usernamefield;
	@FindBy(name="password")private WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']")private WebElement signinfield;
	@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")private WebElement admin;
@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")private WebElement logout;
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
	public void clickOnAdminLink()
	{
		
		admin.click();
	}
	public void clickOnLogout()
	{
		logout.click();
	}

}
