package SeleniumPOM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidebarPage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement home;
    WebElement practice;
    WebElement courses;
    WebElement blog;
    WebElement contact;


    public SidebarPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHome() {
        return driver.findElement(By.id("menu-item-43"));
    }

    public WebElement getPractice() {
        return driver.findElement(By.id("menu-item-20"));
    }

    public WebElement getCourses() {
        return driver.findElement(By.id("menu-item-21"));
    }

    public WebElement getBlog() {
        return driver.findElement(By.id("menu-item-19"));
    }

    public WebElement getContact() {
        return driver.findElement(By.id("menu-item-18"));
    }

    //--------------------------------------------------------------

    public void clickHome() {
        this.getHome().click();
    }

    public void clickPractice() {
        this.getPractice().click();
    }

    public void clickCourses() {
        this.getCourses().click();
    }

    public void clickBlog() {
        this.getBlog().click();
    }

    public void clickContact() {
        this.getContact().click();
    }

    //-------------------------------------------------------

    public String getHomeText() {
        return this.getHome().getText();
    }


}
