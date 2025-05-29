package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
    public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
    public void selectDropdownWithIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
	}
    public void selectDropdownWithVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
    public void selectCheckbox(WebElement element) {
		element.click();
	}
    public void selectRadioButton(WebElement element) {
		element.click();
	}
    public void verifyMouseover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
    public  void javaScriptClick(WebElement element,WebDriver driver) {
    	JavascriptExecutor javascript=(JavascriptExecutor)driver;//casting by creating reference for the interface
		javascript.executeScript("arguments[0].click();", element);	}
}
