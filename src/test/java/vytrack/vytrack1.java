package vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vytrack1 {
    public static void main(String[] args) {

        // Does not return any arguments and returns text of the web element as a String
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://vytrack.com/user/login.html");
        String actualText = driver.findElement(By.tagName("h3")).getText(); // returns a String
        String expectedText = "Login";
        if(actualText.equals(expectedText)){
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!");
        }

    }
}
