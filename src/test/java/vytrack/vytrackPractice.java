package vytrack;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class vytrackPractice {

    WebDriver driver;

    String cybertekHoverURL = "http://practice.cybertekschool.com/hovers";
    String vytrackLoginURL = "https://qa2.vytrack.com/user/login";
    String userName = "user178";
    String password = "UserUser123";
    Actions action;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(vytrackLoginURL);
        action = new Actions(driver);
    }

    @Test
    public void practice() {
        //create figure1 webElement
        WebElement figure1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        //hover over figure1
        action.moveToElement(figure1).perform();
        WebElement user1Name = driver.findElement(By.xpath("//h5[.='name: user1']"));
        String expectedName = "name: user1";
        String actualName = user1Name.getText();
        //verify user name
        Assert.assertEquals(actualName, expectedName, "user name does not match");
        WebElement profile = driver.findElement(By.xpath("//div[@class='figure'][1]//a"));
        //click on profile link
        profile.click();
        WebElement bodyText = driver.findElement(By.xpath("//h1"));
        //verify body text
        String expectedText = "Not Found";
        String actualText = bodyText.getText();
        Assert.assertEquals(actualText, expectedText, "Text does not match");
    }

    @Test
    public void Vytrack_Hover_Practice() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
//        WebElement fleet = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[1]/a/span"));
//
//        action.moveToElement(fleet).perform();
        Thread.sleep(3000);
        WebElement System = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[4]/a/span"));
        action.moveToElement(System).perform();
        Thread.sleep(3000);
        WebElement userManagement = driver.findElement(By.xpath(" //span[.='User Management']"));
        action.moveToElement(userManagement).perform();
        Thread.sleep(5000);
        WebElement users = driver.findElement(By.xpath("//span[.='Users']"));
//        users.click();
        action.click(users).perform();
        Thread.sleep(5000);
        WebElement firstName = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        action.moveToElement(firstName).perform();
        Thread.sleep(5000);
        WebElement edit = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/i"));
        action.click(edit).perform();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}


