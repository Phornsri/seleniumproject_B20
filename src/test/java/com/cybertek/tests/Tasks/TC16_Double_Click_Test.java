package com.cybertek.tests.Tasks;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC16_Double_Click_Test {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

      driver.manage().window().maximize();

      //  1.Go to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
      driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2") ;

        BrowserUtils.wait(2000);

        //2.Switch	to	iframe.
       WebElement iFrame = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']") );
       BrowserUtils.wait(2000) ;


      //3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        WebElement doubleClick = Driver.getDriver().findElement(By.xpath("//p[@id='demo']") );
        BrowserUtils.wait(2000) ;


      //4.Assert:	Text’s	“style”	attribute	value	con
       WebElement textStyle = Driver.getDriver().findElement(By.xpath("//p[@style='color: red;']") ) ;
        Assert.assertTrue(textStyle.isDisplayed());

        Driver.closeDriver();

    }
}
