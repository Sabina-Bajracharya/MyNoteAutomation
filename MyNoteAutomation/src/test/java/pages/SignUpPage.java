//package pages;
//
//import org.openqa.selenium.*;
//
//public class SignUpPage {
//
//    WebDriver driver;
//
//    public SignUpPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void register(String name, String email, String password) {
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/a[2]")).click();
//        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//    }
//}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void register(String name, String email, String password) {
        // Scroll and click Sign Up link
        WebElement signUpLink = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary btn-lg px-4']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpLink);
        wait.until(ExpectedConditions.visibilityOf(signUpLink));
        try {
            signUpLink.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpLink);
        }

        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        nameInput.sendKeys(name);

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        emailInput.sendKeys(email);

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordInput.sendKeys(password);

        WebElement confirmInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
        confirmInput.sendKeys(password);

        // Click Submit
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
    }
}