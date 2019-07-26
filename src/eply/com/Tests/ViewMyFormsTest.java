package eply.com.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import eply.com.PageObject.LoginPage;
import eply.com.PageObject.ViewMyFormsPage;

public class ViewMyFormsTest extends BaseTest{

	@Test
	public void dropDown() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(2000);

		ViewMyFormsPage viewMy = new ViewMyFormsPage(driver);
		viewMy.dropdown(6);
		Thread.sleep(3000);
		String expected = "Forms: 3";
		String actual = "Forms: " + Integer.toString(viewMy.numForms());
		assertEquals(actual, expected);
	}

	@Test
	public void dropDownFail() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(2000);

		ViewMyFormsPage viewMy = new ViewMyFormsPage(driver);
		viewMy.dropdown(6);
		Thread.sleep(3000);
		String expected = "Forms: 0";
		String actual = "Forms: " + Integer.toString(viewMy.numForms());
		String message = "\nShall Fail\n";
		assertEquals(actual, expected, message);
	}

}
