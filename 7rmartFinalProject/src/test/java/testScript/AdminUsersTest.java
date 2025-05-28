package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base

{
	HomePage homepage;
	AdminUsersPage adminuserspage;

	@Test(description = "Verifying Admin user can add new users successfully ")
	public void verifyCustomerCanAddNewUsersSuccesfullyInNewAdminusersFiled() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		RandomDataUtility randomdatautility = new RandomDataUtility();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickLoginButtonField();
    	adminuserspage=homepage.clickAdminUsersField();
		String newadminuser = randomdatautility.createRandomUsername();
		String newadminpassword = randomdatautility.createRandomPassword();
		adminuserspage.clickAddNewAdminUserField();
		adminuserspage.enterNewAdminUserUsername(newadminuser).enterNewAdminUserPassword(newadminpassword).selectNewAdminUserType().clickSaveNewAdminUserField(); 
		boolean isalertdispalyed=adminuserspage.userCreatedValidationMessage();
		Assert.assertTrue(isalertdispalyed,Messages.ADDADMINUSERERROR);
	}

	@Test(description = "Verifying newly added admin  users can search successfully ")
	public void verifyCustomerCanSearchNewlyAddedAdminUserSuccesfullyInAdminusersSearchFiled() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		RandomDataUtility randomdatautility = new RandomDataUtility();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickLoginButtonField();
		adminuserspage=homepage.clickAdminUsersField();
		String testadminuser = ExcelUtility.readStringData(0, 0, "AdminUserPage");
		adminuserspage.clickSearchAdminUserField().enterSearchAdminUsername(testadminuser).selectSearchAdminUserType().clickSearchAdminUserButton();
		String expected="Active";
		String actual=adminuserspage.getSearchUserActivetext();
		Assert.assertEquals(actual, expected,Messages.SEARCHADMINUSERERROR);
	}

}
