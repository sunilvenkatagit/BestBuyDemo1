package com.bestbuy.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.bestbuy.pages.DetailsPage;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.SearchResultsPage;

/*
 * @author Sunil Venkata
 *
  */

public class HomePageTests extends BaseTest {

	@Test(priority = 1, enabled = true, description = "Home page title")
	public void verifyHomePageTitle() {
		// Use java generic's
		String title = page.getInstance(HomePage.class).getHomePageTitle();
		
		log.info("<---Home Page Title Test---> " + title);
		
		System.out.println("<---Home Page Title---> " + title);
		Assert.assertEquals(title, prop.getProperty("HomePageTitle"));
	}

	@Test(priority = 2, enabled = true, description = "Search an item")
	public void doSearch() {
		SearchResultsPage resultsPage = page.getInstance(HomePage.class).searchItem(prop.getProperty("itemName"));
		String resultsPageHeader = resultsPage.getSearchResultsPageHeader();
		System.out.println("<---Search Results Page Header---> " + resultsPageHeader);
		Assert.assertEquals(resultsPageHeader, prop.getProperty("resultsPageHeader"));
	}

	@Test(priority = 3, enabled = true, description = "Empty search")
	public void emptySearch() {
		SearchResultsPage resultsPage = page.getInstance(HomePage.class).searchItem();
		String emptyRsltPgHeader = resultsPage.getEmptyRsltPgHeader();
		System.out.println("<---Empty Search Results Page Header---> " + emptyRsltPgHeader);
		Assert.assertEquals(emptyRsltPgHeader, prop.getProperty("emptyRsltPgHeader"));

	}

	@Test(priority = 4, enabled = true)
	public void selectingItem() {

		SearchResultsPage resultsPage = page.getInstance(HomePage.class).searchItem(prop.getProperty("itemName"));
		String resultsPageHeader = resultsPage.getSearchResultsPageHeader();
		System.out.println("<---Search Results Page Header---> " + resultsPageHeader);
		Assert.assertEquals(resultsPageHeader, prop.getProperty("resultsPageHeader"));

		DetailsPage detailsPage = page.getInstance(SearchResultsPage.class).clickAnItem();
		String detailsPgHdr = detailsPage.getDetailsPgHdr();
		System.out.println("<---Product details Page Header---> " + detailsPgHdr);
		Assert.assertEquals(detailsPgHdr, prop.getProperty("dtlsPgHdr"));
	}

}
