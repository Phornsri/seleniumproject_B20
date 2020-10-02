package vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OdometerTest {

    WebDriver driver;
    String browserType = "chrome";
    //Truck driver Credentials
    String URL = "https://qa2.vytrack.com/user/login";
    String userName = "user178";
    String password = "UserUser123";

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test//Milena - User Story#5 - AC#3 - DONE
    public void Odometer_page_Should_Not_Load() throws InterruptedException{
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user178");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123"+ Keys.ENTER);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//[@id='main-menu']/ul/li[1]/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/div/div/ul/li[4]")).click();

        //need verification

    }

    @Test//Gokhan -User Story #4 - AC #6 - DONE
    public void userStory4AC6() throws InterruptedException {

        driver.findElement(By.className("span2")).sendKeys("user178");
        driver.findElement(By.name("_password")).sendKeys("UserUser123"+ Keys.ENTER);
        //Navigate to Fleet module
        driver.findElement(By.linkText("Fleet")).click();
        //Opening Vehicle Odometer under Fleet module
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        //Navigating to ellipsis
        Thread.sleep(3000);


        Actions action = new Actions(driver);
        WebElement ellipsis = driver.findElement(By.xpath("//tbody/tr[2]//a[@class='dropdown-toggle']"));
        action.moveToElement(ellipsis).perform();
        //Hover over "Edit" option & Open
        driver.findElement(By.xpath("//a[@title ='Edit']")).click();
        //Clicking "Save And Close" button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class = 'btn btn-success action-button']")).click();
        //Compare actual result Vs. expected result
        String actualResult = driver.getTitle();
        String expectedResult = "- Entities - System - Car - Entities - System";
        if (actualResult.contains(expectedResult)) {
            System.out.println("Edited information page \"Entities\" is displayed!");
        } else {
            System.out.println("Edited information page \"Entities\" is NOT displayed!");
        }
    }

    @Test//Nick - User Story #4 - AC#7 - DONE
    public void reset_grid() throws InterruptedException{
        System.out.println("The title of the page is: " + driver.getTitle());
        String actualTitle = driver.getTitle();
        System.out.println("ACTUAL TITLE STRING: " + actualTitle);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl =" + actualUrl);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("_submit")).click();
        String expected = "Dashboard";
        String actual = driver.getTitle();
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        System.out.println(expected.equals(actual)?"Pass:":"Fail");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String ParentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent Window Handle " + ParentWindowHandle);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        for(String childTab:driver.getWindowHandles())
        {
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span")).click();
        }
        //Select "Vehicle Odometer" from drop box.
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/div/div/ul/li[4]/a/span")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String URL1 = "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer";
        driver.get(URL1);
        System.out.println("The title of the page is: " + driver.getTitle());
        String ParentWindowHandleGearIcon = driver.getWindowHandle();
        System.out.println("Parent Window Handle " + ParentWindowHandleGearIcon);
        // Selects the gear icon on the screen
        try{
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[3]/div[1]/div/div/a")).click();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("");
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Selects ID checkbox
        driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Closes Grid Settings box
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[3]/div[1]/div/div/a")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Clicks on Reset Grid
        driver.findElement(By.xpath("//a[@title='Reset']")).click();
    }

    @Test//Anara - User Story #4 - AC#3 - DONE
    public void delete_single_vehicle() throws InterruptedException{

        System.out.println("The title of the page is: " + driver.getTitle());
        String actualTitle = driver.getTitle();
        System.out.println("ACTUAL TITLE STRING: " + actualTitle);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl =" + actualUrl);
        Thread.sleep(3000);
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("_submit")).click();
        String expected = "Dashboard";
        String actual = driver.getTitle();
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        System.out.println(expected.equals(actual)?"Pass:":"Fail, because it is not matching");
        //System.out.println(expected.contains("1"));
        System.out.println(expected.charAt(5));
        Thread.sleep(2000);
        // Now i am going to locate an element for "Fleet"
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.linkText("Fleet")).click();
        //driver.findElement(By.xpath("(//span[@class='title title-level-2'])[2]")).click();
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(3000);
        //Select "Vehicle Odometer" from drop box.
        //driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/div/div/ul/li[4]/a/span")).click();
        //click single driver info
        driver.findElement(By.xpath("//tr[@class='grid-row row-click-action'][1]") ).click();
        //driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action'])[1]/td[1]")).click();
        Thread.sleep(3000);
        //find on the delete button
        driver.findElement(By.xpath("//a[@class=' btn icons-holder-text no-hash remove-button']")).click();
        Thread.sleep(3000);
        //click yes on delete button
        driver.findElement(By.xpath("//a[@class='btn ok btn-danger']")).click();
        //Thread.sleep(3000);


        //need verification
    }

    @Test//Conor - User Story #4 - AC#8 - DONE
    public void delete_multiple_vehicles() {
        //Input username
        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(userName);
        //Input password
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(password);
        //Submitting credentials
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();
        //Selects fleet
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span")).click();
        //Selects vehicle odometer
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/div/div/ul/li[4]/a/span")).click();
        //Clicks multiple vehicles
        WebElement vehicleOne = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/input"));
        WebElement vehicleTwo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/input"));
        vehicleOne.click();
        vehicleTwo.click();
        //Vehicle selection confirmation
        if (vehicleOne.isSelected() && vehicleTwo.isSelected()) {
            System.out.println("Two vehicles have been selected");
        } else {
            System.out.println("Vehicles have not been selected");
        }
        //Clicks ellipsis
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/thead/tr/th[7]/div/button")).click();
        //Clicks delete button
        driver.findElement(By.xpath("/html/body/ul/li/a")).click();
        //Switch to pop up window
        driver.switchTo().activeElement().findElement(By.xpath("/html/body/div[6]/div[3]/a[2]"));
        //Clicks delete button
        WebElement deleteButton = driver.findElement(By.xpath("//*[contains(@class, 'btn ok btn-danger')]"));
        deleteButton.click();

        String expected = "2 entities have been deleted successfully";
        String actual = driver.findElement(By.xpath("//div[@class='message']")).getText();

        System.out.println(actual.equals(expected)?"delete successful":"delete unsuccessful");
    }

    @Test//Cynthia - User Story#4 AC#2 - DONE
    public void create_vehicle_odometer() throws InterruptedException{
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);
        //click Fleet
        driver.findElement(By.linkText("Fleet")).click();
        Thread.sleep(3000);
        //click Vehicle Odometer
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(3000);
        //click Create Vehicle Odometer
        driver.findElement(By.linkText("Create Vehicle Odometer")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']")).sendKeys("12345");
        Thread.sleep(3000);
        //Then user clicks "save and close" button
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        Thread.sleep(3000);

        String expectedValueSaved = "Entity saved";
        String actualValueSaved = driver.findElement(By.xpath("//div[.='Entity saved']")).getText();
        Thread.sleep(3000);
        System.out.println(actualValueSaved.equals(expectedValueSaved)?"Pass":"Fail");
    }

    @Test//Parizat - User Story #4 - AC#5 - DONE
    public void edit_vehicle_odometer() throws InterruptedException{

        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();

        WebElement fleet= driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleet.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/div/div/ul/li[4]/a/span")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//tbody//tr[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Edit Vehicle Odometer']")).click();

        WebElement odometerValue = driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_OdometerValue')]"));
        odometerValue.clear();
        odometerValue.sendKeys("123456");
        driver.findElement(By.xpath("//div[@class='btn-group pull-right']/button")).click();

        String expected = "Entity saved";
        String actual = driver.findElement(By.xpath("//div[.='Entity saved']")).getText();

        System.out.println(actual.contains(expected)?"Pass":"Fail");
    }

    @Test//Omer - User Story #4 - AC#4 - DONE
    public void gridSetting_delete_vehicle_odometer() throws InterruptedException{
        driver.findElement(By.id("prependedInput")).sendKeys("User178");
        Thread.sleep(1500);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep(1500);
        //driver.findElement(By.className("title title-level-2")).click();
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[2]")).click();
        Thread.sleep(1500);
        //<input tabindex="-1" type="checkbox" data-role="select-row-cell">
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        Thread.sleep(2000);
        //<button type="button" class="btn btn-default btn-small dropdown-toggle" data-toggle="dropdown" title="Mass Actions">
        //        <i class="fa-ellipsis-h"></i>
        //        <i class="caret"></i>
        //    </button>
        //
        //click ellipsis
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        Thread.sleep(2000);
        //<a href="#" class="action mode-text-only" title="Delete">
        //
        //
        //        <i class="fa-trash-o"></i>
        //        Delete
        //
        //
        //
        //</a>
        //click delete button
        driver.findElement(By.xpath("(//a[@title='Delete'])[2]") ).click();
        Thread.sleep(2000);
        //click delete button on pop-up
        //<a href="#" class="btn ok btn-danger">Yes, Delete</a>
        driver.findElement(By.xpath("//a[@class='btn ok btn-danger']")).click();
        Thread.sleep(2000);

        String actualMessage = driver.findElement(By.className("message")).getText();
        String expectedMessage = "One entity was deleted";
        Assert.assertEquals(actualMessage,expectedMessage);
        if(actualMessage.contains("One entity")){
            System.out.println("Message verification corrected");
        }else{
            System.out.println("Message verification failed");
        }
        System.out.println(actualMessage);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
