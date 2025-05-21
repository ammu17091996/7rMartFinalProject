package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base

{
	@Test(description = "Verifying Admin user can add new users successfully ")
	public void verifyCustomerCanAddNewUsersSuccesfullyInNewAdminusersFiled() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		RandomDataUtility randomdatautility = new RandomDataUtility();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
    	adminuserspage.clickAddNewAdminUserField();
		String newadminuser = randomdatautility.createRandomUsername();
		String newadminpassword = randomdatautility.createRandomPassword();
		adminuserspage.enterNewAdminUserUsername(newadminuser);
		adminuserspage.enterNewAdminUserPassword(newadminpassword);
		adminuserspage.selectNewAdminUserType();
		adminuserspage.clickSaveNewAdminUserField(); 
		boolean isalertdispalyed=adminuserspage.userCreatedValidationMessage();
		Assert.assertTrue(isalertdispalyed,"User Creation Was Unsuccessfull");
	}

	@Test(description = "Verifying newly added admin  users can search successfully ")
	public void verifyCustomerCanSearchNewlyAddedAdminUserSuccesfullyInAdminusersSearchFiled() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.enterUesrnameOnUserNameField(username);
		adminuserspage.enterPasswordOnPasswordField(password);
		adminuserspage.clickLoginButtonField();
		adminuserspage.clickAdminUsersField();
		adminuserspage.clickSearchAdminUserField();
		String testadminuser = ExcelUtility.readStringData(0, 0, "AdminUserPage");
		adminuserspage.enterSearchAdminUsername(testadminuser);
		adminuserspage.selectSearchAdminUserType();
		adminuserspage.clickSearchAdminUserButton();
		String expected="Active";
		String actual=adminuserspage.getSearchUserActivetext();
		Assert.assertEquals(actual, expected,"Newly added admin user not able to perform search operations successfully");
	}

}
