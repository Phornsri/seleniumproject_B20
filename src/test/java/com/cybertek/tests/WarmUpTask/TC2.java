package com.cybertek.tests.WarmUpTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cyberteks.com");

        String title = driver.getTitle() ;
        System.out.println("title = " + title);

        String urlContains = driver.getCurrentUrl();
        System.out.println("URL contains: " + urlContains);

        String expectedTitle = "cybertekschool";
        String verifyingTitle = driver.getTitle();
        System.out.println(expectedTitle);
        System.out.println("Expected: " + verifyingTitle);

        driver.close();

    }
}
