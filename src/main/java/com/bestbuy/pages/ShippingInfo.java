package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bestbuy.enumrations.UserInfo;

public class ShippingInfo extends BasePage {

	public ShippingInfo(WebDriver driver) {
		super(driver);
	}

	By email = By.id("email");
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By address = By.id("addressLine");
	By city = By.id("city");
	By postalCode = By.id("postalCode");
	By phoneNumber = By.id("phone");
	By paymentButton = By.xpath("//span[contains(text(),'Continue to Payment')]");

	public WebElement getEmail() {
		return getElement(email);
	}

	public WebElement getFirstName() {
		return getElement(firstName);
	}

	public WebElement getLastName() {
		return getElement(lastName);
	}

	public WebElement getAddress() {
		return getElement(address);
	}

	public WebElement getCity() {
		return getElement(city);
	}

	public WebElement getPostalCode() {
		return getElement(postalCode);
	}

	public WebElement getPhoneNumber() {
		return getElement(phoneNumber);
	}

	public WebElement getPaymentButton() {
		return getElement(paymentButton);
	}

	public String getCheckoutPageTitle() {
		return getPageTitle();
	}

	public PaymentPage userInfo() {

		getEmail().sendKeys(UserInfo.EMAIL.toString());
		getFirstName().sendKeys(UserInfo.FIRST_NAME.toString());
		getLastName().sendKeys(UserInfo.LAST_NAME.toString());
		getAddress().sendKeys(UserInfo.ADDRESS.toString());
		getCity().sendKeys(UserInfo.CITY.toString());
		getPostalCode().sendKeys(Keys.CLEAR);
		getPostalCode().sendKeys(UserInfo.POSTAL_CODE.toString());
		getPostalCode().sendKeys(Keys.TAB);
		getPhoneNumber().sendKeys(UserInfo.PHONE_NUMBER.toString());
		getPaymentButton().click();

		return getInstance(PaymentPage.class);
	}

}

/*
 * js.executeScript("document.getElementById('email').value='Avinash Mishra';");
 * 
 */

/*
 * // Using java script is way more faster than any other method and minimizes
 * the code length too...! JavascriptExecutor js = (JavascriptExecutor) driver;
 * js.executeScript(
 * "document.getElementById('email').value='pvsunil1993@gmail.com';"); // this
 * is the best method to write js.executeScript("arguments[0].value='" +
 * "VENKATA SUNIL" + "';", getFirstName());
 * js.executeScript("arguments[0].value='" + "PUCHAGINJALA" + "';",
 * getLastName()); js.executeScript("arguments[0].value='" + "1280, SAINT MARC"
 * + "';", getAddress()); js.executeScript("arguments[0].value='" + "MONTREAL" +
 * "';", getCity()); js.executeScript("arguments[0].value='" + "H3H 2G1" + "';",
 * getPostalCode()); //js.executeScript("arguments[0].click();",
 * getPaymentButton());
 * js.executeScript("document.getElementByXapth().click();");// this is not
 * working js.executeScript("arguments[0].click();", getCheckoutButton()); //
 * this works for clicking
 */