package SeleniumPOM.test;

import SeleniumPOM.base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogOut extends BasePage {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/logged-in-successfully/");
        correctLogin();
    }

    @Test
    public void URL() {
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void logOutButton() {
        Assert.assertTrue(driver.getPageSource().contains("Log out"));
    }

    @Test
    public void loggedInMessage(){
        Assert.assertTrue(driver.getPageSource().contains("Logged In Successfully"));
    }

}
