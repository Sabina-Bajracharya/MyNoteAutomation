package pages;

import org.openqa.selenium.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-lg px-4 me-md-2']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
