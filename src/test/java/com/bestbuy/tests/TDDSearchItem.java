package com.bestbuy.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.SearchResultsPage;
import com.bestbuy.utility.ExcelDataConfig;

public class TDDSearchItem extends BaseTest {

	@DataProvider
	public Object[][] getData() throws Exception {
		ExcelDataConfig config = new ExcelDataConfig(
				"C:\\\\Users\\\\Sunil Venkata\\\\eclipse-workspace\\\\MyFrameworkOOPs\\\\src\\\\main\\\\java\\\\com\\\\bestbuy\\\\utility\\\\TestDataBestBuy.xlsx");

		int rows = config.getRowCount(0);
//		System.out.println(rows);

		Object[][] data = new Object[rows][1];

		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getData(0, i, 0);

		}
		return data;
	}

	@Test(dataProvider = "getData", enabled = true)
	public void dataDrivenSearch(String keyWord) {
		SearchResultsPage resultsPage = page.getInstance(HomePage.class).searchItem(keyWord);
		String resultsPageHeader = resultsPage.getSearchResultsPageHeader();
		System.out.println("<---Search Results Page Header---> " + resultsPageHeader);

	}

}
