package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPageModel extends HelperClass {
    public LoginPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Login Panel
    public final By TestSmithDemoLogo = By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg']");
    public final By YourEmailTextbox = By.cssSelector("input[data-test='email']");
    public final By YourPassword = By.cssSelector("input#password");
    public final By LoginButton = By.cssSelector("input[data-test='login-submit']");
    public final By RegisterYourAccountLink = By.cssSelector("a[data-test='register-link']");
    public final By ForgotYourPasswordLink = By.cssSelector("a[data-test='forgot-password-link']");

    // Footer
    public final By GitHubRepoLink = By.cssSelector("a[href='https://github.com/testsmith-io/practice-software-testing']");
    public final By BarnImagesLink = By.cssSelector("a[href='https://unsplash.com/@barnimages']");
    public final By UnsplashLink = By.cssSelector("a[href='https://unsplash.com/photos/t5YUoHW6zRo']");

    public void clickRegisterAccountLink(){
        RegisterPageModel registerPageModel = new RegisterPageModel(driver, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.RegisterYourAccountLink));
        driver.findElement(this.RegisterYourAccountLink).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPageModel.RegisterButton));
    }
    public void login(String email, String password){
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        testSmithDemoMainPageModel.setTextbox(this.YourEmailTextbox, email);
        testSmithDemoMainPageModel.setTextbox(this.YourPassword, password);
        driver.findElement(this.LoginButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.LoginButton));
    }
}
