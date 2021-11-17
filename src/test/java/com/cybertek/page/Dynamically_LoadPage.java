package com.cybertek.page;

import com.cybertek.tests.Tasks.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dynamically_LoadPage {
    public Dynamically_LoadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement enterUsername;

    @FindBy(xpath = "//input[@id='pwd']")
    public WebElement enterPassword;

    @FindBy(xpath = "//button[@type= 'submit']")
    public WebElement submitButton;

    @FindBy(id= "flash")
    public WebElement invalidMessage;

    @FindBy(id="loading")
   public  WebElement loadingPage;


}
