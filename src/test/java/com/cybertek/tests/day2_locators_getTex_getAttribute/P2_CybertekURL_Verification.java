package com.cybertek.tests.day2_locators_getTex_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURL_Verification {
    public static void main(String[] args) {
        //TC #2: Cybertek verifications
        //1. Open Chrome browser
        // I need to set up my browser driver.
        WebDriverManager.chromedriver().setup();

        // to creat instance of chrome browser from webDriver
        WebDriver driver = new ChromeDriver();

        // this line will maximize the newly opened browser page
        driver.manage().window().maximize();

        //2. Go to https://practice.cybertekschool.com
        driver.get("http://practice.cybertekschool.com");

        //3. Verify URL contains
        //Expected: cybertekschool
        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl() ;

        if(actualUrl.contains(expectedInUrl) ){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!!");
        }

        //4. Verify title:
        //Expected: Practice
        if(driver.getTitle().equals("Practice") ){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }


    }
}
