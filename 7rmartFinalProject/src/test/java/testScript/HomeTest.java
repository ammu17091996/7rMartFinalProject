package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(description = "Verifying whether logged in users can logout succesfully")
	public void verifyLogoutIsSuccesfullForLoggedinUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUesrnameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickLoginButtonField();
		homepage.clickOnAdminLink();
		loginpage=homepage.clickOnLogout();
		String expected="7rmart supermarket";
		String actual=homepage.getLoginPageText();
		Assert.assertEquals(actual, expected,Messages.LOGOUTERROR);
	}
}
