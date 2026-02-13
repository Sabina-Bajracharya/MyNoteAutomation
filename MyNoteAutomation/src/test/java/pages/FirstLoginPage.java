package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FirstLoginPage {

    WebDriver driver;

    public FirstLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void firstlogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='text-decoration-none me-3']")));
        successAlert.click();
    }
}


