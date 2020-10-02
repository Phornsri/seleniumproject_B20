package HelpDesk28;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

/*
Given user is on CRM 24 Dashboard
When user navigates to Task tab
Then user selects Upload files icon
Then user click Upload files and images link
Then user picks a local file or image
Then user clicks open button
Then user click Download from external drive link
Then user selects available document
Then user clicks Select document button
Then user clicks Select document from Bitrix24 link
Then user select available files
Then user click select document button
Then user clicks Create using Desktop applications link
Then user selects an option
Then user verify selected files uploaded successfully
 */
public class Sprint1_AC3 {

    WebDriver driver;
    public com.cybertek.utilities.WebDriverFactory WebDriverFactory;

    @BeforeMethod
    public void setupMethod() {
        // open a new browser
        driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");
        String URL = "https://login2.nextbasecrm.com/stream/?login=yes";
        String Login = "helpdesk28@cybertekschool.com";
        String password = "UserUser";


        driver.get(URL);
        System.out.println("The title of the page is: " + driver.getTitle());
        String actualTitle = driver.getTitle();
        System.out.println("ACTUAL TITLE STRING: " + actualTitle);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl =" + actualUrl);


    }
}
