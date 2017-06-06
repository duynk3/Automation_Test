package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import constant.AWBConstant;
import util.AutomationUtil;

public class CreateTemplate {
	private WebDriver driver;
	public static String driverPath = "C:/Users/duynk3/Downloads/soft/chromedriver_win32/";

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void openHomePage() {
		driver.get(AWBConstant.awbURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		// TODO
		login();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login() {
		WebElement tenantName = AutomationUtil.findETCElement("id", "tenantName", driver);
		tenantName.sendKeys("default-tenant");
		WebElement signInButton = AutomationUtil.findETCElement("xpath", "//button[contains(.,'Sign In')]", driver);
		signInButton.click();
	}

}
