package com.cybertek.utilities;
/*
    Task: New Method Creation
* Method name: getDriver
* Static method
* Accepts string argument: browserType --> will determine what browser opens
* return type: WebDriver
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* TASK: NEW METHOD CREATION
   Method name: getDriver
   Static method
   Accepts string argument: browserType --> will determine what browser opens
       -> if "chrome" opens chrome browser
       -> if "firefox" opens firefox browser
   return type: WebDriver
    */

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }else{
            System.out.println("given browser does not exist. driver=null!");
            return null;
        }



    }

}
