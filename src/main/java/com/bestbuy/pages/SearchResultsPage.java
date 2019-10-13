package com.bestbuy.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {

	By header = By.xpath("//h1[contains(text(),'Results for:')]");
	By onlineOffer = By
			.xpath("//div[contains(@class,'availabilityMessageSearch')]//div//span[2][text()='Available online only']");
	By allItems = By.xpath("//div[contains(text(),'Apple iPhone')]");
	By emptyHdr = By.xpath("//span[text()='0 results']");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public List<WebElement> getOnlineOffer() {
		return getElements(onlineOffer);
	}

	public List<WebElement> getAllItems() {
		return getElements(allItems);
	}

	public WebElement getEmptyHdr() {
		return getElement(emptyHdr);
	}

	public String getSearchResultsPageTitle() {
		return getPageTitle();
	}

	public String getSearchResultsPageHeader() {
		return getPageHeader(header);
	}

	public String getEmptyRsltPgHeader() {
		return getPageHeader(emptyHdr);
	}

	public DetailsPage clickAnItem() {

		for (int i = 0; i < getAllItems().size(); i++) {
			String itemName = getAllItems().get(i).getText();
			// System.out.println(itemName);
			if (itemName.contains("Apple iPhone XR 64GB - Black - Refurbished")) {
				for (int j = 0; j < getOnlineOffer().size(); j++) {
					String onlineOffer = getOnlineOffer().get(j).getText();
					// System.out.println(onlineOffer);
					if (onlineOffer.contains("Available online only")) {
						getAllItems().get(i).click();
						break;
					}
				}
				break;
			}
		}
		return getInstance(DetailsPage.class);
	}
}
