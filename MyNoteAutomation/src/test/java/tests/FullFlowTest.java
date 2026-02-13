package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;
import pages.SignUpPage;

import java.util.UUID;

public class FullFlowTest extends BaseTest {

    @Test
    public void completeNotesFlow() {
        // 1️⃣ SignUp Page

        SignUpPage signUp = new SignUpPage(driver);


//        String email = "user" + UUID.randomUUID() + "@test.com";
        String name = "TestUser";
        String email ="test@gmail.com";
        String password = "Test123!";

        signUp.register(name, email, password);

        // -----------------------------
        // 2️⃣ Login Page
        // -----------------------------
        LoginPage login = new LoginPage(driver);

        login.login(email, password);  // use the same credentials you just signed up with

       //Notes Page
        NotesPage notes = new NotesPage(driver);

        // Create a note
        notes.createNote("My First Note", "This is a test note");

        // Edit the note
        notes.editNote("My Edited Note");

        // Delete the note
        notes.deleteNote();
        System.out.println("Full flow completed successfully!");
    }
}