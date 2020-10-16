package Sprint3_Smoke_Test_Suite;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sprint3_UserStory1_AC3 {
    WebDriver driver;
    public com.cybertek.utilities.WebDriverFactory WebDriverFactory;

    @BeforeMethod
    public void setupMethod() {
        driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");
        String URL = "https://login2.nextbasecrm.com/stream/?login=yes";

        driver.get(URL);
        driver.findElement(By.xpath("//input[@ name='USER_LOGIN']")).sendKeys("helpdesk28@cybertekschool.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();


    }

    @Test
    public void uploadFile() {

//    AC#3 -User should be able to attach link by clicking on the link icon.
//    Given user is on CRM 24 dashboard
        driver.findElement(By.xpath("//span[@id='logo_24_text']")).click();
        BrowserUtils.wait(3);

//    And user navigate to message tab
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']/span")).click();
        BrowserUtils.wait(3);

        //    Then user clicks on Link icon
        driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']")).click();
        BrowserUtils.wait(3);

//    Then user should able add Url and name of Link

    }
}
