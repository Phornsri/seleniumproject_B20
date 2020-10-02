package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Task1 {
    public static void main(String[] args) throws InterruptedException {
        //TC #2: SeleniumEasy Checkbox Verification – Section 1
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // locate success message and checkbox under 'single checkbox demo'
        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']") );

         //locate the success message
        //create a locator to success message and share it in class-chat
        //div[@style='display: block;']
        //div[.='Success - Check box is checked']
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        //3. Verify “Success – Check box is checked” message is NOT displayed.
        if(!successMessage.isSelected() && !successMessage.isDisplayed() ){
            System.out.println("successMessage is not Displayed. Verification PASSED");
        }else {
            System.out.println("successMessage is  Displayed. Verification FAILED");
        }

        //4. Click to checkbox under “Single Checkbox Demo” section
        successCheckbox.click() ;

        //5. Verify “Success – Check box is checked” message is displayed.
        if(successMessage.isSelected() && successMessage.isDisplayed() ){
            System.out.println("successMessage is Displayed. Verification PASSED");
        }else {
            System.out.println("successMessage is NOT Displayed. Verification FAILED");
        }

        Thread.sleep(300) ;
        driver.close() ;

    }
}
