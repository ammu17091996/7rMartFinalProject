package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base

{
	@Test(description="Verifying user login with valid credentials")
public void verifyLoginIsSuccessfullWithValidCredentials() throws IOException
{
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();

}
	@Test(description="Verifying user login with valid username and invalid password")
	public void verifyUserNotabletoLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();

	}
	@Test(description="Verifying user login with Invalid username and Valid password")	
	public void verifyUserNotabletoLoginWithInvalidUsernamevalidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
	}
	@Test(description="Verifying user login with Invalid credentials")
	public void verifyUserNotabletoLoginWithInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLoginButtonField();
	}
}
