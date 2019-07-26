package eply.com.Tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import eply.com.PageObject.ForgotPasswordPage;
import eply.com.PageObject.LoginPage;
public class ForgotPasswordTest extends BaseTest{

	@Test(description = "Checks if it's posible to restore forgotten details - message shall be appeared")
	public void isRestoreAvailable() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.forgotPasswordBtn();
		ForgotPasswordPage forgotPassword = new ForgotPasswordPage(driver);
		forgotPassword.forgotPassDetails("sasha@gmail.com");
		boolean expected = true;
		boolean actual = forgotPassword.isMsgAppeared();
		assertEquals(actual, expected);
	}

	@Test(description = "Checks if it's posible to restore forgotten details - message shall be appeared")
	public void msgText() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.forgotPasswordBtn();
		ForgotPasswordPage forgotPassword = new ForgotPasswordPage(driver);
		forgotPassword.forgotPassDetails("sasha@gmail.com");
		String expected = "instructions on how to reset your password have "
				+ "been sent to the email address registered with the username provided.";
		String actual = forgotPassword.getMsg();
		assertEquals(actual, expected);
	}
}
