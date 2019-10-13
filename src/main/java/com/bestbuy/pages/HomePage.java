package com.bestbuy.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * @author Sunil Venkata
 *
 */
public class HomePage extends BasePage {

	// page locators
	private By searchBx = By.xpath("//input[@placeholder='Search Best Buy']");
	private By searchBtn = By.xpath("//button[@class='searchButton_T4-BG fitContainer_3GscR']");
	private By links = By.tagName("a");
	private By images = By.tagName("img");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getSearchBx() {
		return getElement(searchBx);
	}

	public WebElement getSearchBtn() {
		return getElement(searchBtn);
	}

	public List<WebElement> getLinks() {
		return getElements(links);
	}

	public List<WebElement> getImages() {
		return getElements(images);
	}

	
	public String getHomePageTitle() {
		return getPageTitle();
	}

	
	public SearchResultsPage searchItem(String itemName) {
		getSearchBx().sendKeys(itemName);
		getSearchBtn().click();
		return getInstance(SearchResultsPage.class);
	}

	
	public SearchResultsPage searchItem() {
		getSearchBtn().click();
		return getInstance(SearchResultsPage.class);
	}

	public HomePage homePageLinks() throws MalformedURLException, IOException {
		List<WebElement> listOfLinks = getLinks();
		listOfLinks.addAll(getImages());

		System.out.println("Total no of links & images (including Not Active) " + listOfLinks.size());

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 9; i < listOfLinks.size(); i++) {
			// System.out.println(listOfLinks.get(i).getAttribute("href"));
			if (listOfLinks.get(i).getAttribute("href") != null
					&& !listOfLinks.get(i).getAttribute("href").contains("javascript:")) {
				//
				activeLinks.add(listOfLinks.get(i));
				// System.out.println(activeLinks.get(i).getAttribute("href"));
			}
		}
		System.out.println("Total no of ACTIVE links & images " + activeLinks.size());

		for (int j = 0; j < activeLinks.size(); j++) {

			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			// String response = connection.getResponseMessage();
			int response = connection.getResponseCode();
			connection.disconnect();

			if (response >= 400) {
				System.out.println(activeLinks.get(j).getAttribute("href") + " This link is not valid " + response);
			}
//			 else {
//				System.out.println("Link is valid!");
//			}

			// System.out.println(activeLinks.get(j).getAttribute("href") + "<----->" +
			// response);

		}
		// If there are no broken links
		System.out.println("All the link are working fine in Home Page!");
		return getInstance(HomePage.class);
	}

}
