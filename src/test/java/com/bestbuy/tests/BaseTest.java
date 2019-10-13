package com.bestbuy.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bestbuy.pages.BasePage;
import com.bestbuy.pages.Page;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	Logger log;
	public Page page;

	/*
	 * Before method
	 */
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUp(String browser) throws InterruptedException {

		log = LogManager.getLogger(BaseTest.class.getName());

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("No browser is defined in testNG xml file...!");
		}

		log.info(browser + " browser is opened!");

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Sunil Venkata\\eclipse-workspace\\MyFrameworkOOPs\\src\\main\\java\\com\\bestbuy\\utility\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Configuration properties file cannot be found");
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		// driver.get("https://www.bestbuy.ca/en-ca");
		driver.get(prop.getProperty("url"));

		log.info("URL is opened");

		wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.urlToBe(prop.getProperty("url")));
			// Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("url is not loaded completly...!");
			e.printStackTrace();
		}
		page = new BasePage(driver);
	}

	/*
	 * After method
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();

		log.info("Browser is closed!");

	}
	
	/*
	 * Screenshot on failure
	 */
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File(
				"C:\\Users\\Sunil Venkata\\OneDrive\\Documents\\Selenium Notes\\E2Eproject failed screennshots\\"
						+ result + "screenshot.png"));

	}

	

}
