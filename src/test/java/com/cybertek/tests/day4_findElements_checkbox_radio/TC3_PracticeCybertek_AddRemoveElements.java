package com.cybertek.tests.day4_findElements_checkbox_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC3_PracticeCybertek_AddRemoveElements {
    public static void main(String[] args) {


//    public static void main(String[] args) {
//        TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
//    1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

//    2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements");

        // 3. Click to “Add Element” button 50 times

        // 4. Verify 50 “Delete” button is displayed after clicking.
        // 5. Click to ALL “Delete” buttons to delete them.
        // 6. Verify “Delete” button is NOT displayed after clicking.

        // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        // Hint: Need to use findElements method.
    }
}


