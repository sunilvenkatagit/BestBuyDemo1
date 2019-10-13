package com.bestbuy.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
		
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public String getErrorMessage(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public void waitForPageTitle(String url) {
		try {
			wait.until(ExpectedConditions.titleContains(url));
		} catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element  " + url);
			e.printStackTrace();
		}
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element  " + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occured while creating an element " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	// doubt
	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			List<WebElement> elements1 = driver.findElements(locator);
			return elements1;
		} catch (Exception e) {
			System.out.println("Some error occured while creating  elements " + locator.toString());
			e.printStackTrace();
		}
		return elements;
	}

	@Override
	public Select selectElement(By locator) {
		select = null;
		try {
			waitForElementPresent(locator);
			select = new Select(driver.findElement(locator));
			return select;
		} catch (Exception e) {
			System.out.println("Some error occured while SELECTING an element " + locator.toString());
			e.printStackTrace();
		}
		return select;
	}

	@Override
	public Actions moveToElement(By locator) {
		Actions action = null;
		try {
			waitForElementPresent(locator);
			action = (Actions) driver.findElement(locator);
			return action;
		} catch (Exception e) {
			System.out.println("Some error occured while MOVING to an element " + locator.toString());
			e.printStackTrace();
		}
		return action;
	}

}
