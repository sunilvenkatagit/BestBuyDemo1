package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YourCart extends BasePage {

	By header = By.xpath("//h1[@class='title_3A6Uh']");
	By checkoutButton = By
			.xpath("//section[@class='cost-sum-section_2v3QX']//div[contains(text(),'Continue to Checkout')]");

	public YourCart(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public String getYourCartPgHdr() {
		return getPageHeader(header);
	}

	public WebElement getCheckoutButton() {
		return getElement(checkoutButton);
	}

	public GuestCheckout checkOutButton() {
		// Using java script to directly click on the element
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", getCheckoutButton());
		} catch (Exception e) {
			System.out.println("Element not clicked");
			e.printStackTrace();
		}

		return getInstance(GuestCheckout.class);
	}

}
