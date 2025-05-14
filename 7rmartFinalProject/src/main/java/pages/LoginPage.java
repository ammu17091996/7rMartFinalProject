package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage 

	{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(name="username")private WebElement usernamefield;
	@FindBy(name="password")private WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']")private WebElement signinfield;

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

	}

