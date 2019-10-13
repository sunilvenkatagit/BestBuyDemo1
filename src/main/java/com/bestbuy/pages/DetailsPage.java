package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailsPage extends BasePage {

	By prdctNm = By.xpath("//h1[contains(@class,'productName_19xJx')]");
	By header = By.xpath("//li//span[@property='item']");
	By onlineOnly = By.xpath("//span[contains(text(),'Available online only')]");
	By cartButton = By.xpath("//span[contains(text(),'Add to Cart')]");
	By cartIcon = By.xpath("//span[@class='label']");
	By cartCounter = By.xpath("//span[@class='counter']");

	public DetailsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getprdctNm() {
		return getElement(prdctNm);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public WebElement getOnlineOnly() {
		return getElement(onlineOnly);
	}

	public WebElement getCartButton() {
		return getElement(cartButton);
	}

	public WebElement getCartIcon() {
		return getElement(cartIcon);
	}

	public WebElement getCartCounter() {
		return getElement(cartCounter);
	}

	public String getProductName() {
		return getPageHeader(prdctNm);
	}

	public String getDetailsPgHdr() {
		return getPageHeader(header);
	}

	public String getOnlineOnlyMssg() {
		return getPageHeader(onlineOnly);
	}

	public YourCart addToCart() {

		getCartButton().click();
		/*try {
			wait.until(ExpectedConditions.presenceOfElementLocated(cartButton));
		} catch (Exception e) {
			System.out.println("your cart is emty message is displayed and gone");
			e.printStackTrace();
		}*/
		getCartCounter().isDisplayed();
		getCartIcon().click();
		return getInstance(YourCart.class);
	}

}
