package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.FirstLoginPage;
import pages.NotesPage;
import pages.SignUpPage;

import java.util.UUID;

public class FullFlowTest extends BaseTest {

    @Test
    public void completeNotesFlow() {

        // Create Account Page
        SignUpPage signUp = new SignUpPage(driver);
        String name = "TestUser";
//        String email ="test@gmail.com";
        String email = "user" + UUID.randomUUID() + "@test.com";
        System.out.println(email);
        String password = "Test123!";

        signUp.register(name, email, password);

        // Logout
        FirstLoginPage firstloginPage = new FirstLoginPage(driver);
        firstloginPage.firstlogin();

        // Login Page
        LoginPage login = new LoginPage(driver);
        login.login(email, password);

       //Notes Page
        NotesPage notes = new NotesPage(driver);
        // Create a note
        notes.createNote("Automation Note", "This note consist of the automation process for My Notes.");
        // Edit the note
        notes.editNote("Automation Note2");
        // Delete the note
        notes.deleteNote();
        System.out.println("Full flow test completed successfully!");
    }
}
