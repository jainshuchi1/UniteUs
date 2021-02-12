package com.uniteus.uiautomation.UniteusUIAutomation.model;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProvidersFilter {

	private WebDriver driver;

	private By name = By.id("searchInput");;
	
	private By firstResult = By.xpath("/html/body/section/div/div[2]/section[1]/div/article[1]");
	private By searchText = By.xpath("/html/body/section/div/div[1]/div[2]/img[2]");
	private By accordion = By.className("accordion");
	private By providedBy = By.xpath("/html/body/section/div/div[2]/section[1]/div/article[1]/p");
	private By providerAddress = By.xpath("/html/body/section/div/div[2]/section[1]/div/article[1]/address");
	
	
	
	public ProvidersFilter(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement name() {
		WebElement element = driver.findElement(name);
		assertTrue(element.isEnabled());
		return element;
	}

	public WebElement firstResult() {
		WebElement element = driver.findElement(firstResult);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		assertTrue(element.isDisplayed());
		assertTrue(element.isEnabled());
		
		return element;
	}
	public WebElement searchText() {
		WebElement element = driver.findElement(searchText);
		assertTrue(element.isEnabled());
		return element;
	}
	public WebElement accordion() {
		WebElement element = driver.findElement(accordion);
		assertTrue(element.isDisplayed());
		return element;
	}

	public WebElement providedBy() {
		WebElement element = driver.findElement(providedBy);
		assertTrue(element.isEnabled());
		return element;
	}
	public WebElement providerAddress() {
		WebElement element = driver.findElement(providerAddress);
		assertTrue(element.isDisplayed());
		return element;
	}
	public void clickFirstResult() {
		WebElement element = firstResult();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
