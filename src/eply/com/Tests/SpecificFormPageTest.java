package eply.com.Tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import eply.com.PageObject.LoginPage;
import eply.com.PageObject.SpecificFormPage;
import eply.com.PageObject.ViewMyFormsPage;

public class SpecificFormPageTest extends BaseTest{

	@Test(description = "This test checks page's title")
	public void currentPage() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(5000);
		ViewMyFormsPage viewMy = new ViewMyFormsPage(driver);
		viewMy.dropdown(4);
		SpecificFormPage formPage = new SpecificFormPage(driver);
		formPage.clickForm(2);
		String expected = "ePly - General Settings";
		String actual = formPage.pageTitle();
		assertEquals(actual, expected);
	}

	@Test(description = "This test checks is error message exist - shall fail")
	public void isErrorExist() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(5000);
		ViewMyFormsPage viewMy = new ViewMyFormsPage(driver);
		viewMy.dropdown(4);
		SpecificFormPage formPage = new SpecificFormPage(driver);
		formPage.clickForm(2);
		formPage.fillFormInformation("Automation", "POM Automation - Registration", "05/30/2019");
		boolean expected = false;
		boolean actual = formPage.isExist();
		assertEquals(actual, expected);
	}

	@Test(description = "This test checks error message while attempt to create event with the same name")
	public void eventSaved() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(5000);
		ViewMyFormsPage viewMy = new ViewMyFormsPage(driver);
		viewMy.dropdown(4);
		SpecificFormPage formPage = new SpecificFormPage(driver);
		formPage.clickForm(2);
		formPage.fillFormInformation("Automation", "POM Automation - Registration", "05/30/2019");
		String expected = "That event name is already taken, please choose a unique name";
		String actual = formPage.errMsgMethod();
		assertEquals(actual, expected);
	}
}
