package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestCheckout extends BasePage {

	By header = By.xpath("//span[contains(text(),'No account? No problem. You can checkout without a')]");
	By continueButton = By.xpath("//span[contains(text(),'Continue')]");

	public String getGuestCheckoutHeader() {
		return getPageHeader(header);
	}

	public WebElement getContinueButton() {
		return getElement(continueButton);
	}

	public GuestCheckout(WebDriver driver) {
		super(driver);
	}

	public ShippingInfo continueToCheckout() {
		getContinueButton().click();
		return getInstance(ShippingInfo.class);
	}
}
