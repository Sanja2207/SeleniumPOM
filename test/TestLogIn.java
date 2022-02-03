package SeleniumPOM.test;

import SeleniumPOM.base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

public class TestLogIn extends BasePage {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void homeTextTest() {
        String expectedText = "home";
        Assert.assertEquals(sidebarPage.getHomeText().toLowerCase(Locale.ROOT), expectedText);
    }

    @Test
    public void userCanLogin() {
        String validUsername = "student";
        String validPassword = "Password123";

        goToLoginPage();
        loginPage.insertUsername(validUsername);
        loginPage.pass(validPassword);
        loginPage.clickOnSubmit();

        Assert.assertTrue(logoutPage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        String invalidUsername = "wrong";
        String validPassword = "Password123";
        String expectedErrorMessage = "Your username is invalid!";

        goToLoginPage();
        loginPage.insertUsername(invalidUsername);
        loginPage.pass(validPassword);
        loginPage.clickOnSubmit();

        waiter(loginPage.getErrorMessage());

        //da li je poruka prikazana
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());

        //da li ovako glasi poruka
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    @Test
    public void userCannotLogInWithInvalidPassword(){
        String validUsername = "student";
        String invalidPassword = "wrong";
        String expectedErrorMessage = "Your password is invalid!";

        goToLoginPage();
        loginPage.insertUsername(validUsername);
        loginPage.pass(invalidPassword);
        loginPage.clickOnSubmit();
        waiter(loginPage.getErrorMessage());
        Assert.assertEquals(loginPage.getErrorMessageText(),expectedErrorMessage);


    }
}
