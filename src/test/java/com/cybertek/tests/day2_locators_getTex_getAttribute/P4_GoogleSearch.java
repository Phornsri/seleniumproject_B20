package com.cybertek.tests.day2_locators_getTex_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearch {
    public static void main(String[] args) {
        //TC #4: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();

        //open browser and create an instance of the driver
        WebDriver driver = new ChromeDriver();

        //2- Go to: https://google.com
        driver.get("https://google.com");


        //3- Write “apple” in search box
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        //4- Click google search button
        //5- Verify title:
        //Expected: Title should start with “apple” word
        String expectedTitle = "apple - Google Search";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle) ){
            System.out.println("Search title verification PASSED!!");
        }else{
            System.out.println("Search title verification FAILED!!");
        }
    }
}
