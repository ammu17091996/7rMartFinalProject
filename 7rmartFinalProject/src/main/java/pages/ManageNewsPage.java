package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement managenewsfield;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newnewsField;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newstextarea;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement managenewsField;

	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveNewsButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchnewsfield;
	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement newsTitleField;

	@FindBy(xpath = "//button[@value='sr']")
	private WebElement NewsSearchButton;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement newscreationmessage;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement serachedelementediticon;


	public void clickOnManageNewsField() {
		managenewsfield.click();
	}

	public void clickOnNewNewsField() {
		newnewsField.click();

	}

	public void enterNewNewsOnTextarea(String testnewsdata) {
		newstextarea.sendKeys(testnewsdata);

	}

	public void clickOnSaveNewsButton() {
		saveNewsButton.click();

	}

	public void clickOnSearchNewsButton() {
		searchnewsfield.click();

	}

	public void enterNewsTitleForSearch(String testnews) {
		newsTitleField.sendKeys(testnews);

	}

	public void clickOnSearchButton() {
		NewsSearchButton.click();

	}

	public boolean getNewsCreationSuccessMessage() {
		return newscreationmessage.isDisplayed();
	}
	public boolean getSearchElementEditIconVisibility() {
		return serachedelementediticon.isDisplayed();
	}
}
