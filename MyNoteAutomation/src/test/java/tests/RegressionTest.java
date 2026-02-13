package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class RegressionTest extends BaseTest {

    @Test(groups = {"regression"})
    public void editAndDeleteNote() {

        LoginPage login = new LoginPage(driver);
        NotesPage notes = new NotesPage(driver);

        login.login("test@gmail.com", "Test123!");
        notes.createNote("Old Title", "Desc");
        notes.editNote("Updated Title");
        notes.deleteNote();
    }
}
