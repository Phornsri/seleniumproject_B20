package com.cybertek.tests.Tasks;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC17_Context_Click_HomeWork {

        WebDriver driver;

        @BeforeMethod
        public void setupMethod () {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // 1.Go	to	https://the-internet.herokuapp.com/context_menu
            driver.get("https://the-internet.herokuapp.com/context_menu");

        }

        @Test
        public void TC17_ContextClick(){

            //TC	#17:	Context	Click	–HOMEWORK

            WebElement boxRightClick = driver.findElement(By.id("hot-spot") );
            BrowserUtils.wait(3);

            // 2.Right	click	to	the	box.
            Actions act = new Actions(driver);
            act.contextClick(boxRightClick).perform();

            BrowserUtils.wait(3);

            // 3.Alert	will	open.
            Alert alert = driver.switchTo().alert();


            // 4.Accept	alertNo	assertion	needed	for	this	practice.
             alert.accept() ;




        }
    }


