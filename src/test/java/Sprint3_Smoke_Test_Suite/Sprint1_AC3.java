package Sprint3_Smoke_Test_Suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
 Given user is on CRM 24 Dashboard
  When user navigates to Task tab
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']")).click();
                //  And user clicks on Checklist link
                // HERE !!!!!! I TRIED THESE 3 DIFFERENT ONES TO CLICK ON CHECKLIST
                util.Wait(2);
                driver.findElement(By.xpath("//span[.='Checklist']")).click();
                util.Wait(2);
                //driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link']")).click();
                // driver.findElement(By.linkText("Checklist")).click();
                //  Then user enters a task to Things to do
                driver.findElement(By.xpath("//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")).sendKeys("testimg");
                //  And user clicks on add button(or check box)
                util.Wait(2);
                driver.findElement(By.xpath("//span[contains(@class,'apply task-field-title-ok')]")).click();
                // Then user should see added task
                util.Wait(2);
*/

public class Sprint1_AC3 {

    WebDriver driver;
    public com.cybertek.utilities.WebDriverFactory WebDriverFactory;

    @BeforeMethod
    public void setupMethod() {
        // open a new browser
        driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");

        String URL = "https://login2.nextbasecrm.com/stream/?login=yes";

        driver.get(URL);
        driver.findElement(By.xpath("//input[@ name='USER_LOGIN']") ).sendKeys("helpdesk28@cybertekschool.com");
        driver.findElement(By.xpath("//input[@type='password']") ).sendKeys("UserUser") ;
        driver.findElement(By.xpath("//input[@value='Log In']") ).click() ;

    }
    @Test
    public void uploadFile() {
        //Given user is on CRM 24 Dashboard
        //When user navigates to Task tab
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']")).click();
        //Then user selects Upload files icon
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']")).click();
        //Then user click Upload files and images link
        //Then user clicks open button
        driver.findElement(By.xpath("(//input[@type='file'])[5]")).sendKeys("C:\\Users\\gokha\\uploadFile.txt");
        //Then user click Download from external drive link
        driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-light-title diskuf-selector-link-cloud'])[5]")).click();
        //TODO: Bug; not allowed to select from Select one or more documents
        //Then user selects available document
        //Then user clicks Select document button
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("(//span[.='Cancel'])[2]")).click();
        //Then user clicks Select document from Bitrix24 link
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[.='Select document from Bitrix24'])[5]")).click();
        //Then user select available files
        driver.findElement(By.linkText("uploadFile (1).txt")).click();
        //Then user click select document button
        driver.findElement(By.xpath("//span[.='Select document']")).click();
        //Then user clicks Create using MS Office Online  link
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-text'])[5]")).click();
        //Then user select Desktop applications link
        driver.findElement(By.xpath("//span[.='Desktop applications']")).click();
        // Then user selects an option
        //TODO: bitrix24_desktop(1).exe is being downloaded to the PC so no Assertion
        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("(//span[.='Cancel'])[2]")).click();
        //Then user verify selected files uploaded successfully

    }
}
