package com.uniteus.uiautomation.UniteusUIAutomation.test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.uniteus.uiautomation.UniteusUIAutomation.common.BasicSetup;
import com.uniteus.uiautomation.UniteusUIAutomation.common.Constants;
import com.uniteus.uiautomation.UniteusUIAutomation.common.Wait;

public class ProvidersFilterTest extends BasicSetup {

	
	@Test
	public void testProvidersFilter() {

		wait.explicitlyFor(providersFilter.accordion(), 10);

		
		String searchText = utility.getProperty(Constants.TEST_DATA, "searchText");
		providersFilter.name().sendKeys(searchText);

		wait.explicitlyFor(providersFilter.searchText(), 10);
		providersFilter.searchText().click();

		Wait.sleep(3000);

		providersFilter.clickFirstResult();

		Wait.sleep(3000);

		Assert.assertTrue(card.providerCardName().getText()
				.equals(card.providerName().getText()), "Provider Name values do not match");

		Assert.assertTrue(
				providersFilter.providedBy().getText().equals(card.providedBy().getText()),
				"Provider By values do not match");

		Assert.assertTrue(
				providersFilter.providerAddress().getText()
						.equals(card.address().getText()),
				"Provider Address values do not match");

		report.testcase = report.extent.createTest("testProvidersFilter", "PASSED");

	}

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		report.extent.flush();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		report.getResult(result);
	}

}
