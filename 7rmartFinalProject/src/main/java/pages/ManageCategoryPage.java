package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
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

	

	

	public ManageCategoryPage clickOnAddNewCategoryField() {
		Newcategoryfield.click();
		return this;
	}

	public ManageCategoryPage EnterCategory(String categoryname) {
		category.sendKeys(categoryname);
		return this;
	}

	public ManageCategoryPage selectGroup() {
		selectgroup.click();
		return this;
	}

	public ManageCategoryPage uploadImage() {
		image.sendKeys(Constant.IMAGEDATA);
		return this;
	}

	public ManageCategoryPage saveCategory() {
		pageutility.javaScriptClick(savecategorybutton, driver);
		//JavascriptExecutor javascript = (JavascriptExecutor) driver;// casting by creating reference for the interface
		//javascript.executeScript("arguments[0].click();", savecategorybutton);
		return this;
	}

	public ManageCategoryPage selectShowOntopmenu() {

		Showontopmenuradio.click();
		return this;
	}

	public ManageCategoryPage searchCategory() {
		searchcategory.click();
		return this;
	}

	public ManageCategoryPage enterCategorynameforSearch(String searchcategoryname) {
		categoryforsearch.sendKeys(searchcategoryname);
		return this;
	}

	public ManageCategoryPage clickOnSearchCategoryButton() {
		searchcategorybutton.click();
		return this;
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
