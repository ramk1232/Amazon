package DataDrivenTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Amz.Log4data;
import Utils.Utility;

public class DataDriven {
	
	WebDriver driver;
	Log4data Lo;

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fie%3DUTF8%26tag%3Dgoogmantxtmob50-21%26ascsubtag%3D_k_CjwKCAjw8JKbBhBYEiwAs3sxN2BXdv8KcdTQTImP3k9yWguloUR0N1ZUpFaV8h7XAAPU9EQT0LqkiBoCijoQAvD_BwE_k_%26gclid%3DCjwKCAjw8JKbBhBYEiwAs3sxN2BXdv8KcdTQTImP3k9yWguloUR0N1ZUpFaV8h7XAAPU9EQT0LqkiBoCijoQAvD_BwE%26ref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	}

	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("before method is running");

		Lo = new Log4data(driver);
		Thread.sleep(1000);	
		Lo.enterusername(Utility.getTD(0, 1));
		Lo.continu();
		Lo.enterpass(Utility.getTD(1, 1));
		Lo.submit();
	
	}

	@Test
	public void test() {
		System.out.println("test method is running");

		Lo = new Log4data(driver);
		Lo.submit();

		String url = driver.getCurrentUrl(); // Actual

		boolean result = (url.equals("https://www.amazon.in/"));
		Assert.assertEquals(result, "https://www.amazon.in/");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterclass() {
		 driver.close();
	}

}
