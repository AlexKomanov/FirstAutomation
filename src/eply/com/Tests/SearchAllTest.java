package eply.com.Tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import eply.com.PageObject.LoginPage;
import eply.com.PageObject.MyFormsPage;
import eply.com.PageObject.SearchAllPage;

public class SearchAllTest extends BaseTest{

	@Test(description = "Checks if message is desplayed")
	public void isDisplayed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(5000);
		MyFormsPage myFormsPage = new MyFormsPage(driver);
		myFormsPage.openSearchAll();
		Thread.sleep(5000);
		SearchAllPage searchAllPage = new SearchAllPage(driver);
		searchAllPage.search("7/12/2017 12:00 AM", "1/27/2019 12:00 AM", "shavit1986@gmail.com");
		Thread.sleep(3000);
		boolean expected = true;
		boolean actual = searchAllPage.isMsgDisplayed();
		assertEquals(actual, expected);
	}

	@Test(description = "Checks message text")
	public void msgText() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(5000);
		MyFormsPage myFormsPage = new MyFormsPage(driver);
		myFormsPage.openSearchAll();
		Thread.sleep(5000);
		SearchAllPage searchAllPage = new SearchAllPage(driver);
		searchAllPage.search("7/12/2017 12:00 AM", "1/27/2019 12:00 AM", "shavit1986@gmail.com");
		Thread.sleep(3000);
		String expected = "The search was done";
		String actual = searchAllPage.isSearchSucceed();
		assertEquals(actual, expected);
	}

}