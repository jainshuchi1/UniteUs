package com.uniteus.uiautomation.UniteusUIAutomation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uniteus.uiautomation.UniteusUIAutomation.model.ProviderCard;
import com.uniteus.uiautomation.UniteusUIAutomation.model.ProvidersFilter;

public class BasicSetup {
	public WebDriver driver;
	public String username = "";
	public String password = "";
	
	private String browser = "";
	
	public ProvidersFilter providersFilter;
	public ProviderCard card;
	public Wait wait;
	public Utility utility = new Utility();
	public Report report;


	public BasicSetup() {
		
		String url = utility.getProperty(Constants.RUN_CONFIGURATION, "url");
		setup(url);
		
		wait = new Wait(driver);
		wait.implicitlyFor(10);
		providersFilter = new ProvidersFilter(driver);
		card = new ProviderCard(driver);
		
		report = new Report(utility.getProperty(Constants.RUN_CONFIGURATION, "OS"), browser);
		report.startReport();
	}

	public void setup(String url) {

		driverSetup();
		driver.get(url);
		
	}

	private void driverSetup() {
		browser = utility.getProperty(Constants.RUN_CONFIGURATION, "browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver", "src/resources/drivers/firefox");
		} else if(browser.equalsIgnoreCase("Safari")) {
			System.setProperty("webdriver.safari.driver", "src/resources/drivers/safaridriver");
		} else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.internetexplorer.driver", "src/resources/drivers/internetexplorerdriver");
		}

		driver.manage().window().maximize();
		
	}
	

	
}
