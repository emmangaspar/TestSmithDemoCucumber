package hooks.stepDefinitions;

import helper.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModels.*;

import java.time.Duration;

public class TestSmithDemosteps extends HelperClass {
    WebDriver driver;
    WebDriverWait wait;
    ChromeOptions driverOptions;
    String email;
    String password = userData.PASSWORD.toString();

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driverOptions = new ChromeOptions();
        driver = new ChromeDriver(driverOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("Value of driver is" + wait +" ");
    }
    @When("The user will navigate to the Registration page")
    public void the_user_will_navigate_to_the_registration_page() {
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        LoginPageModel loginPageModel = new LoginPageModel(driver, wait);

        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(testSmithDemoMainPageModel.DynamicNavigationLink("nav-sign-in")));
        testSmithDemoMainPageModel.navigateTo("nav-sign-in");
        loginPageModel.clickRegisterAccountLink();
    }
    @When("The user will fill all the required fields before submitting using the register button")
    public void the_user_will_fill_all_the_required_fields_before_submitting_using_the_register_button() {
        RegisterPageModel registerPageModel = new RegisterPageModel(driver, wait);
        // Registration of randomized person
        email = registerPageModel.registerRandomUser();
    }
    @When("User enters the email and password")
    public void user_enters_the_email_and_password() {
        LoginPageModel loginPageModel = new LoginPageModel(driver, wait);
        loginPageModel.login(email, password);
    }
    @When("The user will navigate to the Categories Hand Tools page")
    public void the_user_will_navigate_to_the_categories_hand_tools_page() {
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        testSmithDemoMainPageModel.selectSubNavigationMenu("nav-categories","nav-hand-tools");
    }
    @When("The user will select a product select the quantity then click the add to cart button")
    public void the_user_will_select_a_product_select_the_quantity_then_click_the_add_to_cart_button() {
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        CategoryToolsPageModel categoryToolsPageModel = new CategoryToolsPageModel(driver, wait);
        ProductPageModel productPageModel = new ProductPageModel(driver, wait);

        // Selecting a tool item to add to cart
        categoryToolsPageModel.selectACategoryItem("product-6");
        productPageModel.addSelectedItemToCart(3);
        testSmithDemoMainPageModel.navigateTo("nav-cart");
    }
    @When("The user will fill all the required payment fields to be able to checkout the product")
    public void the_user_will_fill_all_the_required_payment_fields_to_be_able_to_checkout_the_product() {
        CheckoutCartPageModel checkoutCartPageModel = new CheckoutCartPageModel(driver, wait);
        checkoutCartPageModel.clickProceedToCheckoutButton();
        checkoutCartPageModel.clickSignInProceedToCheckoutButton();
        checkoutCartPageModel.setBillingAddress(userData.ADDRESS.toString(), userData.CITY.toString(), userData.STATE.toString(), "PH", userData.POSTALCODE.toString());
        checkoutCartPageModel.clickBillingProceedToCheckoutButton();
        checkoutCartPageModel.setPaymentInfoAndConfirm(paymentMethod.PAYMENT_METHOD.toString(),paymentMethod.ACCOUNT_NAME.toString(), paymentMethod.ACCOUNT_NUMBER.toString());
    }
    @Then("The product will successfully be paid")
    public void the_product_will_successfully_be_paid() {
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(testSmithDemoMainPageModel.SuccessStatusMessageLabel));
    }
    @Then("The user will close the browser")
    public void the_user_will_close_the_browser() {
        driver.quit();
    }
}
