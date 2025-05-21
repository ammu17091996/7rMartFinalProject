package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageCategoryPage {
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinfield;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	private WebElement managecategoryfield;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement Newcategoryfield;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement image;
	@FindBy(xpath = "//input[@name='top_menu']")
	private WebElement Showontopmenuradio;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savecategorybutton;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchcategory;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryforsearch;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchcategorybutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath="//span[text()='Active']")
	WebElement searchcategoryfoundmessage;

	public void enterUesrnameOnUserNameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickLoginButtonField() {
		signinfield.click();
	}

	public void clickOnManageCategoryField() {
		managecategoryfield.click();
	}

	public void clickOnAddNewCategoryField() {
		Newcategoryfield.click();
	}

	public void EnterCategory(String categoryname) {
		category.sendKeys(categoryname);
	}

	public void selectGroup() {
		selectgroup.click();
	}

	public void uploadImage() {
		image.sendKeys(Constant.IMAGEDATA);
	}

	public void saveCategory() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;// casting by creating reference for the interface
		javascript.executeScript("arguments[0].click();", savecategorybutton);
	}

	public void selectShowOntopmenu() {

		Showontopmenuradio.click();
	}

	public void searchCategory() {
		searchcategory.click();
	}

	public void enterCategorynameforSearch(String searchcategoryname) {
		categoryforsearch.sendKeys(searchcategoryname);
	}

	public void clickOnSearchCategoryButton() {
		searchcategorybutton.click();
	}
	public boolean getAlertMessageForSuccessfullCategoryCreation()
	{
		return alertmessage.isDisplayed();
	}
	public String getSearchedCategoryMessage()
	{
		return searchcategoryfoundmessage.getText();
	}

}
