package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends Base

{
	@Test(description = "Verifying whether logged in user can add new news in manage news section ")
	public void verifyCustomerCanAddNewNewsSuccesfullyInManageNewsFiled() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		managenewspage.clickOnManageNewsField();
		managenewspage.clickOnNewNewsField();
		RandomDataUtility randomdatautility = new RandomDataUtility();
		String testnewsdata = randomdatautility.createRandomName();
		managenewspage.enterNewNewsOnTextarea(testnewsdata);
		managenewspage.clickOnSaveNewsButton();
		boolean newscreationmessage=managenewspage.getNewsCreationSuccessMessage();
		Assert.assertTrue(newscreationmessage,Messages.ADDNEWSERROR);
	}

	@Test(description = "Verifying whether logged in user can search newly added news in manage news section")
	public void verifyCustomerCanSearchNewlyAddedNewsSuccesfullyInManageNewsSearchFiled() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		managenewspage.clickOnManageNewsField();
		managenewspage.clickOnSearchNewsButton();
		String testnews = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenewspage.enterNewsTitleForSearch(testnews);
		managenewspage.clickOnSearchButton();
		boolean searchedelement=managenewspage.getSearchElementEditIconVisibility();
		Assert.assertTrue(searchedelement,Messages.SEARCHNEWSERROR);
	}
}
