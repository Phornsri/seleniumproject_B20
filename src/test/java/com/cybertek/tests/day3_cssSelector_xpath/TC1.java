package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {
    /*
    TC #1: Facebook title verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify title:
    Expected: “Facebook -Log In or Sign Up”
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle ) ){
            System.out.printf("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }



    }
}
