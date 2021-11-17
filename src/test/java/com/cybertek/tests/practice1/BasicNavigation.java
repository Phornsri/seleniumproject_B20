package com.cybertek.tests.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        // to set up chrome driver
        WebDriverManager.chromedriver().setup();
        // to create an object of chrome driver
        ChromeDriver driver = new ChromeDriver();
        String url = "http://www.google.com";
        String url2 = "http://www.amzon.com";
        // will open browser with url
        driver.get(url);
        // will put on hold current run on 3 seconds
        Thread.sleep(3000);

        driver.navigate().to(url2);
        Thread.sleep(3000);

        // will navigate back to the previos URL
        //in our case it's a google.com
        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        // will close web browser
        driver.close();

    }
}
