package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description = "Verifying whether logged in users can logout succesfully")
	public void verifyLoginIsSuccessfullWithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		HomePage homepage = new HomePage(driver);
		homepage.enterUesrnameOnUserNameField(username);
		homepage.enterPasswordOnPasswordField(password);
		homepage.clickLoginButtonField();
		homepage.clickOnAdminLink();
		homepage.clickOnLogout();
		String expected="7rmart supermarket";
		String actual=homepage.getLoginPageText();
		Assert.assertEquals(actual, expected,"Logged-in user not able to log out successfully");
	}
}
