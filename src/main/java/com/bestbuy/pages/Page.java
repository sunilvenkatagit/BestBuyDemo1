/*Abstract Methods and Classes in Java
Abstract methods, similar to methods within an interface, are declared without any implementation. 
They are declared with the purpose of having the child class provide implementation. They must 
be declared within an abstract class.
A class declared abstract may or may not include abstract methods. They are created with the 
purpose of being a super class.
Notes:
Abstract classes and methods are declared with the 'abstract' keyword. Abstract classes can only be 
extended, and cannot be directly instantiated.
Abstract classes provide a little more than interfaces. Interfaces do not include fields and super 
class methods that get inherited, whereas abstract classes do. This means that an abstract class 
is more closely related to a class which extends it, than an interface is to a class that implements it.*/

package com.bestbuy.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	Select select;

	/*
	 * Constructor in Java: A constructor is a special method that builds the object
	 * when a new object is created.
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 20);
	}

	// abstract methods
	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract String getErrorMessage(By locator);

	public abstract WebElement getElement(By locator);

	public abstract Select selectElement(By locator);

	public abstract Actions moveToElement(By locator);

	public abstract List<WebElement> getElements(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
