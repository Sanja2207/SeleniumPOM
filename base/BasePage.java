package SeleniumPOM.base;

import SeleniumPOM.page.LoginPage;
import SeleniumPOM.page.LogoutPage;
import SeleniumPOM.page.PracticePage;
import SeleniumPOM.page.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public LogoutPage logoutPage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        sidebarPage = new SidebarPage(driver, wdwait);
        practicePage = new PracticePage(driver, wdwait);
        loginPage = new LoginPage(driver, wdwait);
        logoutPage = new LogoutPage(driver, wdwait);
    }

    public void waiter(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void goToLoginPage() {
        sidebarPage.clickPractice();
        practicePage.clickOnTestLoginPage();
    }

    public void correctLogin() {
        String validUsername = "student";
        String validPassword = "Password123";

        goToLoginPage();
        loginPage.insertUsername(validUsername);
        loginPage.pass(validPassword);
        loginPage.clickOnSubmit();
    }

    @AfterClass
    public void tearDown() {

        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
