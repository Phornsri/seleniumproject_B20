package com.cybertek.tests.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        // we need to find the element where we would like to double click "Google Search"
        WebElement we = driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));

        // we will use Actions of Selenium WebDriver API
        Action myAction = new Actions(driver).doubleClick(we).build();// step 1
        myAction.perform();// step 2

        Thread.sleep(3000);

        driver.quit();


    }

}
