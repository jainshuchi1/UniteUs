package com.uniteus.uiautomation.UniteusUIAutomation.model;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProviderCard {
	private WebDriver driver;

	private By providerCardName = By.xpath("/html/body/section/section/section/div/h3");
	private By providedBy = By.xpath("/html/body/section/section/section/div/p");
	private By providerName = By.xpath("/html/body/section/section/section/div/h3");
	private By address = By.xpath("/html/body/section/section/section/article/div[1]/div[1]/address");
	private By providerCard = By.xpath("/html/body/section/section");

	
	
	public ProviderCard(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement providerCard() {
		WebElement element = driver.findElement(providerCard);
		assertTrue(element.isEnabled());
		return element;
	}
	public WebElement providerCardName() {
		WebElement element = driver.findElement(providerCardName);
		assertTrue(element.isEnabled());
		return element;
	}
	public WebElement providedBy() {
		WebElement element = driver.findElement(providedBy);
		assertTrue(element.isDisplayed());
		return element;
	}
	public WebElement providerName() {
		WebElement element = driver.findElement(providerName);
		assertTrue(element.isDisplayed());
		return element;
	}
	
	public WebElement address() {
		WebElement element = driver.findElement(address);
		assertTrue(element.isDisplayed());
		return element;
	}
	
}
