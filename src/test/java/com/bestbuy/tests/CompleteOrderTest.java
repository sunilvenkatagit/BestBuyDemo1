package com.bestbuy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bestbuy.pages.DetailsPage;
import com.bestbuy.pages.GuestCheckout;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.PaymentPage;
import com.bestbuy.pages.SearchResultsPage;
import com.bestbuy.pages.ShippingInfo;
import com.bestbuy.pages.YourCart;

public class CompleteOrderTest extends BaseTest {

	@Test(priority = 1, enabled = false)
	public void verifyPaymentErrorMessage() {
		SearchResultsPage resultsPage = page.getInstance(HomePage.class).searchItem(prop.getProperty("itemName"));
		String resultsPageHdr = resultsPage.getSearchResultsPageHeader();
		System.out.println("<---Results Page Header---> " + resultsPageHdr);
		Assert.assertEquals(resultsPageHdr, prop.getProperty("resultsPageHeader"));

		DetailsPage detailsPage = page.getInstance(SearchResultsPage.class).clickAnItem();
		String dtlsPgHdr = detailsPage.getDetailsPgHdr();
		String dtlsPrdctNm = detailsPage.getProductName();
		String offerType = detailsPage.getOnlineOnlyMssg();
		System.out.println("<---Product details Page Header---> " + dtlsPgHdr);
		System.out.println("<---Product info(Details page)---> " + dtlsPrdctNm);
		System.out.println("<---Product offer type (Details page)---> " + offerType);
		Assert.assertEquals(offerType, prop.getProperty("offerType"));
		Assert.assertEquals(dtlsPgHdr, prop.getProperty("dtlsPgHdr"));

		YourCart yourCart = page.getInstance(DetailsPage.class).addToCart();
		String yourCartPgHdr = yourCart.getYourCartPgHdr();
		System.out.println("<---Your Cart Page Header---> " + yourCartPgHdr);
		GuestCheckout guestCheckot = page.getInstance(YourCart.class).checkOutButton();

		String guestCheckotHeader = guestCheckot.getGuestCheckoutHeader();
		System.out.println("<---Guest CheckOut Page Title---> " + guestCheckotHeader);
		Assert.assertEquals(guestCheckotHeader, prop.getProperty("guestCheckotHeader"));

		ShippingInfo shipTo = page.getInstance(GuestCheckout.class).continueToCheckout();
		String shippingTitle = shipTo.getCheckoutPageTitle();
		System.out.println("<---CheckOut Page Title---> " + shippingTitle);
		Assert.assertEquals(shippingTitle, prop.getProperty("checkoutPageTitle"));

		PaymentPage paymentPage = page.getInstance(ShippingInfo.class).userInfo();
		String paymentPageHdr = paymentPage.getHeader();
		System.out.println("<---Payment Page Header---> " + paymentPageHdr);
		Assert.assertEquals(paymentPageHdr, prop.getProperty("paymentPageHdr"));

		PaymentPage creditCardError = page.getInstance(PaymentPage.class).paymentInfo();
		String errorMessage = creditCardError.getErrMessage();
		System.out.println("<---Credit card error message:---> " + errorMessage);
		Assert.assertEquals(errorMessage, prop.getProperty("errorMessage"));
	}

}
