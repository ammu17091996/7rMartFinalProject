package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage

{
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	private WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;
	@FindBy(xpath = "//div[@class='login-logo']")
	private WebElement logintext;
	@FindBy(xpath = "//a[@class='small-box-footer']")
	private WebElement AdminUsers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement managenewsfield;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")
	private WebElement managecategoryfield;


	public HomePage clickOnAdminLink() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		logout.click();
		return new LoginPage(driver);
	}
	public String getLoginPageText()
	{
		return logintext.getText();
	}
	public AdminUsersPage clickAdminUsersField() {
		AdminUsers.click();
		return new AdminUsersPage(driver);

	}
	public ManageNewsPage clickOnManageNewsField() {
		managenewsfield.click();
		return new ManageNewsPage(driver);
	}
	public ManageCategoryPage clickOnManageCategoryField() {
		managecategoryfield.click();
		return new ManageCategoryPage(driver);
	}
}
