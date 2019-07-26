package eply.com.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import eply.com.PageObject.AccountPage;
import eply.com.PageObject.LoginPage;

public class AccountTest extends BaseTest{

	@Test(description = "Checks if the update state exist", testName = "Is Status Exist")
	public void isExist() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(2000);
		AccountPage accountPage = new AccountPage(driver);
		accountPage.clickAccount();
		Thread.sleep(2000);
		accountPage.fillParam("www.alex.co.il", "Mivtza Ben Ami", "Washington", "Israel");
		Thread.sleep(2000);
		boolean expected = true;
		boolean actual = accountPage.isUpdateExist();
		assertEquals(actual, expected);
	}
}
