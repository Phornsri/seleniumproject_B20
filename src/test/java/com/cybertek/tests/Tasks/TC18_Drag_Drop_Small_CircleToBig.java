package com.cybertek.tests.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC18_Drag_Drop_Small_CircleToBig {

    WebDriver driver ;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

    }
    @Test
     public void DragDropSmallCircleToBig() {

    }
    //TC	#16:	Hover	Test

    // 2.Drag	and	drop	the	small	circle	to	bigger	circle.
    Select dragDrop = new Select(driver.findElement(By.id("draggable") ));

    // 3.Assert:	-Text	in	big	circle	changedto:	“You	did	great!”

}
