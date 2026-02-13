package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotesPage {

    WebDriver driver;
    WebDriverWait wait;

    public NotesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // To create a new note
    public void createNote(String title, String description) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary mt-3 mt-lg-0']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']"))).sendKeys(title);

        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(description);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Create']"))).click();
    }

    // To edit an existing note
    public void editNote(String newTitle) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Edit']"))).click();

        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));

        titleField.clear();
        titleField.sendKeys(newTitle);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']"))).click();
    }

    // To delete an existing note
    public void deleteNote() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Delete']")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='button'][normalize-space()='Delete']")
        )).click();
    }
}
