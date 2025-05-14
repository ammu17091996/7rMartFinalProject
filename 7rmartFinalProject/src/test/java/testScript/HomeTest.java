package testScript;

import java.io.IOException;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base 
{

	
	@Test
	public void verifyLoginIsSuccessfullWithValidCredentials() throws IOException
	{
			String username=ExcelUtility.readStringData(0, 0, "LoginPage");
			String password=ExcelUtility.readStringData(0, 1, "LoginPage");
			HomePage homepage=new HomePage(driver);
			homepage.enterUesrnameOnUserNameField(username);
			homepage.enterPasswordOnPasswordField(password);
			homepage.clickLoginButtonField();
			homepage.clickOnAdminLink();
			homepage.clickOnLogout();
			

}
}

