package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import java.util.UUID;

public class SmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void signupLoginCreateNote() {

        String email = "user" + UUID.randomUUID() + "@test.com";
        String password = "Test123!";

        SignUpPage signUp = new SignUpPage(driver);
        LoginPage login = new LoginPage(driver);
        NotesPage notes = new NotesPage(driver);

        signUp.register("TestUser", email, password);
        login.login(email, password);
        notes.createNote("Smoke Note", "Smoke Description");
    }
}