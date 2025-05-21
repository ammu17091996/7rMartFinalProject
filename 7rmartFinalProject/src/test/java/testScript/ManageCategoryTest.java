package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageCategoryTest extends Base {
	@Test(description = "Verifying Add new category in manage category is working successfully ")
	public void verifyCustomerCanAddNewUsersSuccesfullyInNewAdminusersFiled() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.enterUesrnameOnUserNameField(username);
		managecategorypage.enterPasswordOnPasswordField(password);
		managecategorypage.clickLoginButtonField();
		managecategorypage.clickOnManageCategoryField();
		managecategorypage.clickOnAddNewCategoryField();
		RandomDataUtility randomdatautility = new RandomDataUtility();
		String categoryname = randomdatautility.createRandomName();
		managecategorypage.EnterCategory(categoryname);
		managecategorypage.selectGroup();
		managecategorypage.uploadImage();
		managecategorypage.saveCategory();
		boolean alertmessage=managecategorypage.getAlertMessageForSuccessfullCategoryCreation();
		Assert.assertTrue(alertmessage,"Add New Category is not Successfull");

	}

	@Test(description = "Verifying search category in manage category is working successfully ")
	public void verifyCustomerCanSearchCategory() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.enterUesrnameOnUserNameField(username);
		managecategorypage.enterPasswordOnPasswordField(password);
		managecategorypage.clickLoginButtonField();
		managecategorypage.clickOnManageCategoryField();
		managecategorypage.searchCategory();
		String searchcategoryname = ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		managecategorypage.enterCategorynameforSearch(searchcategoryname);
		managecategorypage.clickOnSearchCategoryButton();
		String Expected="Active";
		String actual=managecategorypage.getSearchedCategoryMessage();
		Assert.assertEquals(actual,Expected,"Search Category Not Working");
	}
}