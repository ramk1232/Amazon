package Amz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log4data {
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continu;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement pass;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	// Step 2 : Initialization of Global Variable (data member)

	public Log4data(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3 : Method creation

	public void enterusername(String UN) {
		username.sendKeys(UN);
	}

	public void continu() {
		continu.click();
	}

	public void enterpass(String pwd) {
		pass.sendKeys(pwd);
	}

	public void submit() {
		submit.click();
	}
}
