package com.cybertek.tests.day2_locators_getTex_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
    public static void main(String[] args) {
        //TC #1: Google Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup() ;
        //if you are using browser driver locally you need to use system.setProperty

        //open a chrome browser
        WebDriver driver = new ChromeDriver();


        //2. Go to https://www.google.com
        driver.get("https://www.google.com");


        // 3. Verify title:
        //Expected: Google

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle ) ){
            System.out.printf("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
    }
}
