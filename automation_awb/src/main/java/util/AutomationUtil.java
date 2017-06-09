package util;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationUtil {

	/**
	 * Find WebElement by id/name/class/xpath/css/tagName/PartialLink
	 * @param locator,idString,
	 *            wd : current webdriver
	 * @return WebElement
	 */
	public static WebElement findETCElement(String locator, String idString, WebDriver wd) {
		int attempts = 0;
		WebElement webElement = null;
		while (attempts < 2) {
			if (webElement != null) {
				break;
			}

			try {
				switch (locator) {
				case "id":
					webElement = wd.findElement(By.id(idString));
					break;
				case "name":
					webElement = wd.findElement(By.name(idString));
					break;
				case "class":
					webElement = wd.findElement(By.className(idString));
					break;
				case "xpath":
					webElement = wd.findElement(By.xpath(idString));
					break;
				case "css":
					webElement = wd.findElement(By.cssSelector(idString));
					break;
				case "tagName":
					webElement = wd.findElement(By.tagName(idString));
					break;
				case "partialLink":
					webElement = wd.findElement(By.partialLinkText(idString));
					break;
				}

			} catch (StaleElementReferenceException ex) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
			}
			attempts++;
		}
		return webElement;
	}

	public static void explicitWait(WebDriver wDriver, String sStrategy, String sIdString) {

		int iWaitTime = 60;

		WebDriverWait wdWait = new WebDriverWait(wDriver, iWaitTime);
		switch (sStrategy) {
		case "id":
			// wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sIdString)));
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.id(sIdString))));
			break;
		case "name":
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.name(sIdString))));
			break;
		case "class":
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.className(sIdString))));
			break;
		case "xpath":
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(sIdString))));
			break;
		case "css":
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(sIdString))));
			break;
		case "tagName":
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.tagName(sIdString))));
			break;
		case "partialLink":
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.partialLinkText(sIdString))));
			break;
		default:
			break;
		}
	}

	public static String getCleanPath() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File classpathRoot = new File(classLoader.getResource("").getPath());

		return classpathRoot.getPath();
	}

}
