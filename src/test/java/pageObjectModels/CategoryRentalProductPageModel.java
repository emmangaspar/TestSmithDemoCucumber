package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryRentalProductPageModel extends HelperClass {
    public CategoryRentalProductPageModel(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    // Dynamic Rental Product example product image src string: "assets/img/products/excavator01.jpg"
    public final By DynamicCategoryRentalImageButton(String option) { return By.cssSelector("img[class='card-img']" + "[src='"+option+"']"); }
    public void selectARentalItem(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.DynamicCategoryRentalImageButton(option)));
        driver.findElement(this.DynamicCategoryRentalImageButton(option)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.DynamicCategoryRentalImageButton(option)));
    }
}
