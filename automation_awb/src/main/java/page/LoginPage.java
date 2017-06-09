package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.AutomationUtil;

public class LoginPage {

	public static WebElement tenantName(WebDriver driver){
		WebElement tenantElement = AutomationUtil.findETCElement("id", "tenantName", driver);
		return tenantElement;
	}
	
	public static WebElement signInBtn(WebDriver driver){
		WebElement singInBtn = AutomationUtil.findETCElement("xpath", "//button[contains(.,'Sign In')]", driver);
		return singInBtn;
	}
	
	public static WebElement uName(WebDriver driver){
		WebElement username = AutomationUtil.findETCElement("name", "username", driver);
		return username;
	}
	
	public static WebElement password(WebDriver driver){
		WebElement password = AutomationUtil.findETCElement("name", "password", driver);
		return password;
	}
	
	public static WebElement pxSignInBtn(WebDriver driver){
		WebElement pxSignInBtn = AutomationUtil.findETCElement("xpath", "//input[@value='Sign in']", driver);
		return pxSignInBtn;
	}
	
	
	public static void loginAction(String tenantName, String uname, String password, WebDriver driver){
		tenantName(driver).sendKeys(tenantName);
		signInBtn(driver).click();
		AutomationUtil.explicitWait(driver, "xpath", "//input[@value='Sign in']");
		uName(driver).sendKeys(uname);
		password(driver).sendKeys(password);
		pxSignInBtn(driver).click();
		
	}
	

}
