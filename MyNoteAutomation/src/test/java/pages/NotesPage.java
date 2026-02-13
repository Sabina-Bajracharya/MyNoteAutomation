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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JavaScript click if normal click fails
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // To create a new note
    public void createNote(String title, String description) {
        WebElement addNote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary mt-3 mt-lg-0']")));
        safeClick(addNote);

        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        titleInput.sendKeys(title);

        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(description);

        WebElement create = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Create']")));
        safeClick(create);
    }

    // To edit an existing note
    public void editNote(String newTitle) {
        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Edit']")));
        safeClick(edit);

        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        titleField.clear();
        titleField.sendKeys(newTitle);

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']")));
        safeClick(save);
    }

    // To delete an existing note
    public void deleteNote() {
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='note-delete']")));
        safeClick(delete);

        WebElement confirmDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-header.p-2")));

        WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][normalize-space()='Delete']")));
        safeClick(confirmDelete);
    }
}
