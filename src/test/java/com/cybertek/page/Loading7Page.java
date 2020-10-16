package com.cybertek.page;

import com.cybertek.tests.Tasks.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loading7Page {

    public Loading7Page(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //Lacate "Done!" message
    @FindBy(id= "alert")
    public WebElement doneMessage;


}
