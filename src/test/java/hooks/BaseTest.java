package hooks;

import helper.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest extends HelperClass {

    /*@Before
    public void InitializeTest(){
        WebDriverManager.chromedriver().setup();
        driverOptions = new ChromeOptions();
        driverOptions.addArguments(HelperClass.EnableHeadless);
        driverOptions.addArguments(HelperClass.Resolution);
        driver = new ChromeDriver(driverOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Opening browser
        driver.get(HelperClass.BaseURL);
    }
    @After
    public void EndTest(){
        // Closing app
        driver.quit();
    }*/
}
