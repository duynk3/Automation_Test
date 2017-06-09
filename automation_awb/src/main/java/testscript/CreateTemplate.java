package testscript;

import java.awt.MouseInfo;
import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import page.LoginPage;
import page.TemplateBase;
import util.AWBConstant;
import util.AutomationUtil;

public class CreateTemplate {
	private Pattern nodePattern = new Pattern("C:/Users/duynk3/Desktop/node.PNG");
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
//		driver.quit();
	}

	@Test
	public void test() {
		LoginPage.loginAction("aw-mvp3-dev", "johnsmith", "bcs", driver);
		AutomationUtil.explicitWait(driver, "xpath", "//button[contains(.,'Create Asset')]");
		TemplateBase.createbtn(driver).click();
		AutomationUtil.explicitWait(driver, "id", "templateName");
		Screen screen = new Screen();
		try {
			screen.click(nodePattern);
			Point l = MouseInfo.getPointerInfo().getLocation();
			int x = (int) l.getX();
			int y = (int) l.getY()-50;
			System.out.println(x+"/"+y);
			Actions action = new Actions(driver);
			action.moveByOffset(x, y);
			action.click().build().perform();
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

//	public void login() {
//		WebElement tenantName = AutomationUtil.findETCElement("id", "tenantName", driver);
//		tenantName.sendKeys("default-tenant");
//		WebElement signInButton = AutomationUtil.findETCElement("xpath", "//button[contains(.,'Sign In')]", driver);
//		signInButton.click();
//		
//		
//		
//	}
	
	public void testGoJS(WebDriver dirver) throws Exception {
		
	    String a=   "templateDetailView = document.querySelector('template-detail-view');"+
        "awbGraph = document.querySelector('awb-graph');"+
        "awbGraph._instance.graph.addNode(nodes[0]);"+
        "awbGraph._instance.graph.addNode(nodes[1]);"+
        "awbGraph._instance.graph.addEdge(edge);"+
        "window.seedApp = document.querySelector('seed-app');"+
	    		" window.event = {shiftKey: false};" +
	       " awbGraph._nodeIdsInMultiSelection = [];" +
	        "var obj = {data : {node : {id : '1', data: { attributes: [ {'key' : 'id',children: []}]}}}};"+
	        "awbGraph._onSelectedNode(obj);"+
	        "awbGraph._nodeIdsInMultiSelection = ['1'];"+
	        "obj = {data : {node : {id : '1',data: {attributes: [{'key' : 'id',children: [{'key': 'abc',children: []}]}]}}}};"+
	        "awbGraph._onSelectedNode(obj);"+
	        "document.querySelector('attribute-indentor')._editor.getSession().setValue('address\n\tlat\n\tlon');"+
	        "document.querySelector('attribute-indentor')._TextToJson();"+
	      "});"
	        ;// opening a webpage, which contains gojs diagram
	    JavascriptExecutor js=null;
	    if (driver instanceof JavascriptExecutor) {
	        js = (JavascriptExecutor)driver;
	    } 

	    js.executeScript(a);
	    
		}

}
