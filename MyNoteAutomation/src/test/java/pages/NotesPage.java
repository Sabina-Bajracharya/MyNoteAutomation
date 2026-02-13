package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotesPage {

    WebDriver driver;

    public NotesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //To create a new note.
    public void createNote(String title, String description) {
        driver.findElement(By.xpath("//button[text()='Add Note']")).click();
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(title);
        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(description);
        driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
    }
    
    //To edit an existing note.
    public void editNote(String newTitle) {
        driver.findElement(By.xpath("//button[normalize-space()='Edit']")).click();
        WebElement title = driver.findElement(By.xpath("//input[@id='title']"));
        title.clear();
        title.sendKeys("newTitle");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }
    
    // To delete an existing note.
    public void deleteNote() {

        driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][normalize-space()='Delete']")));
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Delete']")).click();
    }
}
