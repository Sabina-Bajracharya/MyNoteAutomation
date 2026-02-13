package pages;

import org.openqa.selenium.*;

public class NotesPage {

    WebDriver driver;

    public NotesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNote(String title, String description) {
        driver.findElement(By.xpath("//button[text()='Add Note']")).click();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("description")).sendKeys(description);
        driver.findElement(By.xpath("//button[text()='Create']")).click();
    }

    public void editNote(String newTitle) {
        driver.findElement(By.xpath("//button[text()='Edit']")).click();
        WebElement title = driver.findElement(By.id("title"));
        title.clear();
        title.sendKeys(newTitle);
        driver.findElement(By.xpath("//button[text()='Update']")).click();
    }

    public void deleteNote() {
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
    }
}