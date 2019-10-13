package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bestbuy.enumrations.PaymentInfo;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver) {
		super(driver);

	}

	By header = By.xpath("//h2[contains(text(),'Payment')]");
	By cardNumber = By.id("shownCardNumber");
	// By expiryMonth = By.id("expirationMonth");
	By expiryYear = By.id("expirationYear");
	By cvv = By.id("cvv");
	By reviewButton = By.xpath("//span[contains(text(),'Continue to Review')]");
	By errorMessage = By.xpath("//div[contains(text(),'Invalid credit card number. Please check your cred')]");

	public String getHeader() {
		return getPageHeader(header);
	}

	public WebElement getCardNumber() {
		return getElement(cardNumber);
	}

//	public Select getExpiryMonth() {
//		return selectElement(expiryMonth);
//	}

	public Select getExpiryYear() {
		return selectElement(expiryYear);
	}

	public WebElement getCvv() {
		return getElement(cvv);
	}

	public WebElement getReviewButton() {
		return getElement(reviewButton);
	}

	public String getErrMessage() {
		return getErrorMessage(errorMessage);
	}

	public PaymentPage paymentInfo() {
		getCardNumber().sendKeys(PaymentInfo.CARD_NUMBER.toString());
		// getExpiryMonth().selectByValue(PaymentInfo.MONTH.toString());
		getExpiryYear().isMultiple();
		getExpiryYear().selectByValue(PaymentInfo.YEAR.toString());
		getCvv().sendKeys(PaymentInfo.CVV.toString());
		getReviewButton().click();
		return getInstance(PaymentPage.class);

	}

}
