package eply.com.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import eply.com.PageObject.LoginPage;

public class LoginTest extends BaseTest{

	@Test(dataProvider = "getData", description = "Insert wrong login data", testName = "Login Fail Test")
	public void LoginFailure(String username, String password) {	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		String expected = "Sorry, either your username or password was incorrect.";
		String actual = loginPage.getErrorMsg();
		assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = {
				{"Shavit", "1111"},
				{"Dzziiiimmmmaaaa", "333333"},
				{"Sasha", "4234324324324"},
				{"Vitaliy", "vital"},
				{"shavit1986@gmail.com", "shavitdemo123"}, };
		return myData;
	}


	/*
	@Test(priority = 1)
	public void LoginSucceed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		MyFormsPage myForms = new MyFormsPage(driver);
		String expected = "Hello, Shavit!";
		String actual = myForms.welcome();
		assertEquals(actual, expected);
	} */
}
