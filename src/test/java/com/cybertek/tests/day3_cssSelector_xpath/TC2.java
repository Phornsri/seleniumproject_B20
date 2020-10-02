package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {
    /*
   TC #2: Facebook incorrect login title verification
   1.Open Chrome browser
   2.Go to https://www.facebook.com
   3.Enter incorrect username
   4.Enter incorrect password
   5.Verify title changed to:
   Expected: “Log into Facebook | Facebook”
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedTitle = "Log into Facebook | Facebook";
        String actualTitle = driver.getTitle();

        driver.findElement(By.id("email")).sendKeys("FunPage@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123abc"+ Keys.ENTER);
        driver.findElement(By.name("login")).click();

        String actualResult = driver.getTitle();
        driver.close();


        if(actualTitle.equals(expectedTitle ) ){
            System.out.printf("Facebook title verification PASSED!");
        }else{
            System.out.println("Facebook title verification FAILED!");
        }



    }
}
