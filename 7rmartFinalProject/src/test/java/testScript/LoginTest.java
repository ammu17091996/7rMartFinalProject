package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	HomePage homepage;
	@Test(description="Verifying user login with valid credentials",priority=1,retryAnalyzer=retry.Retry.class)
public void verifyLoginIsSuccessfullWithValidCredentials() throws IOException
{
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickLoginButtonField();
		String expected="Dashboard";
		String actual=loginpage.getDashboardText();
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);

}
	@Test(description="Verifying user login with valid username and invalid password",priority=4,groups= {"smoke"})
	public void verifyUserNotabletoLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password).clickLoginButtonField();//not navigating
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
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password).clickLoginButtonField();
		String expected="7rmart supermarket";
		String actual=loginpage.getLoginPageText();
		Assert.assertEquals(actual, expected,Messages.INVALIDUSERNAMEVALIDPASSWORDERROR);
	}
	@Test(description="Verifying user login with Invalid credentials",priority=2, groups= {"smoke"}, dataProvider="loginProvider")
	public void verifyUserNotabletoLoginWithInvalidCredentials(String username,String password) throws IOException
	{
		//String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password).clickLoginButtonField();
		String expected="7rmart supermarket";
		String actual=loginpage.getLoginPageText();
		Assert.assertEquals(actual, expected,Messages.INVALIDCREDENTIALERROR);
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin","admin"},
			                    new Object[] {"123","123"}
			//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
