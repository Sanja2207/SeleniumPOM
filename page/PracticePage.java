package SeleniumPOM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement testLoginPage;
    WebElement testExceptions;

    public PracticePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTestLoginPage() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    public WebElement getTestException() {
        return driver.findElement(By.linkText("Test Exceptions"));

    }
    //------------------------------------------------------------

    public void clickOnTestLoginPage() {
        this.getTestLoginPage().click();
    }

    public void clickOntesExceptions() {
        this.getTestException().click();
    }
}
