package com.bestbuy.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.bestbuy.pages.HomePage;

public class BrokenLinksandImages extends BaseTest {

	@Test(enabled=false)
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		page.getInstance(HomePage.class).homePageLinks();
	}

}
