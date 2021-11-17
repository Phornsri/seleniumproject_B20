package com.cybertek.tests.practice1;

import com.cybertek.page.Dynamically_LoadPage;
import com.cybertek.tests.Tasks.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {
    @Test
    public void dynamic_laod_page1(){
        //TC#41 Dynamically Loaded Page Elements1
        Dynamically_LoadPage dynPage = new Dynamically_LoadPage();

        //1. Go to htt://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        //2. click to start
        dynPage.startButton.click();

       // 3. Wait until loading bar disappers
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10 );
        wait.until(ExpectedConditions.invisibilityOf(dynPage.loadingPage) );

        //4. Assert username : inputbox is displayed
        Assert.assertTrue(dynPage.enterUsername.isDisplayed() );

        //5. Enter password : tomsmith
        dynPage.enterUsername.sendKeys("tomsmith");

        //6. Enter password : incorrectpassword
        dynPage.enterPassword.sendKeys("happy");

        //7. click to submit button
        dynPage.submitButton.click();

        //8. Assert "Your password is invalid!" text is displayed.
        Assert.assertTrue(dynPage.invalidMessage.isDisplayed() );
        Driver.closeDriver();

        //Note: Folloiw POM Design Pattern
        
    }
}
