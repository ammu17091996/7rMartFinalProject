package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base

{
	@Test(description="Verifying user login with valid credentials",priority=1,retryAnalyzer=retry.Retry.class)
public void verifyLoginIsSuccessfullWithValidCredentials() throws IOException
{
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		String expected="Dashboard";
		String actual=loginpage.getDashboardText();
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);

}
	@Test(description="Verifying user login with valid username and invalid password",priority=4)
	public void verifyUserNotabletoLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		String expected="7rmart supermarket";
		String actual=loginpage.getLoginPageText();
		Assert.assertEquals(actual, expected,Messages.VALIDUSERNAMEINVALIDPASSWORDERROR);
		//boolean isalertdisplayed=loginpage.alertVisibility();
		//Assert.assertTrue(isalertdisplayed,"User Login Successfull With Invalid Password");

	}
	@Test(description="Verifying user login with Invalid username and Valid password",priority=3)	
	public void verifyUserNotabletoLoginWithInvalidUsernamevalidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		String expected="7rmart supermarket";
		String actual=loginpage.getLoginPageText();
		Assert.assertEquals(actual, expected,Messages.INVALIDUSERNAMEVALIDPASSWORDERROR);
	}
	@Test(description="Verifying user login with Invalid credentials",priority=2)
	public void verifyUserNotabletoLoginWithInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
		String expected="7rmart supermarket";
		String actual=loginpage.getLoginPageText();
		Assert.assertEquals(actual, expected,Messages.INVALIDCREDENTIALERROR);
	}
}
