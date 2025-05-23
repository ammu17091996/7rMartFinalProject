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



	public void clickOnAdminLink() {
		admin.click();
	}

	public void clickOnLogout() {
		logout.click();
	}
	public String getLoginPageText()
	{
		return logintext.getText();
	}
}
