package com.example.coronatracking.application;

import com.example.coronatracking.application.controller.ControllerAuth;
import com.example.coronatracking.application.controller.ControllerTrack;
import com.example.coronatracking.application.model.request.*;
import com.example.coronatracking.application.model.response.ResponseJwtAuth;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponsePasswordReset;
import com.example.coronatracking.application.repo.RepoUser;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UnitTestsAuth {

    @Autowired
    private ControllerAuth contAuth;
    @Autowired
    private RepoUser repoUser;

    @Test
    void testSignUp() {
        repoUser.deleteAll();
        int NUM_OF_TEST_CASES = 7;

        RequestSignUp[] requests = {
                new RequestSignUp("Selen Uysal",  21,  "selen@bilkent.edu.tr", "selenn", "mysecretpassword"), // Register with correct credentials
                new RequestSignUp("Fatih Uyanık", -10, "fatih15@gmail.com",    "fatih",  "mysecretpassword"), // Test invalid Age
                new RequestSignUp("Fatih Uyanık", 23,  "fatih15@gmail.com",    "fatih",  "mysecretpassword"), // Register with correct credentials
                new RequestSignUp("Kemal Uyanık", 18,  "invalid email",        "sevban", "mysecretpassword"), // Test invalid Email
                new RequestSignUp("Selen Demir",  18,  "selen@gmail.com",      "selenn", "mysecretpassword"), // Test Duplicate Username
                new RequestSignUp("fatih Murat",  22,  "fatih15@gmail.com",    "fmurat", "mysecretpassword"), // Test Duplicate Email
                new RequestSignUp("Aysel Uysal",  25,  "aysel_uysal@gmail.com","aysel",  "abc") // Test too short password.
        };

        boolean[] expected = { true, false, true, false, false, false, false };
        for (int i = 0; i < NUM_OF_TEST_CASES; i++) { testSignUp(requests[i], expected[i]); }
    }

    public void testSignUp(RequestSignUp requestSignUp, Boolean expected) {
        ResponseEntity<ResponseOperation> response = contAuth.signUp(requestSignUp);
        Assert.notNull(response);
        Assert.isTrue(response.getBody().getSuccess() == expected);
    }


    @Test
    void testSignIn() {
        repoUser.deleteAll();
        // Sign Up User
        String username = "fatih";
        String email = "fatih15@gmail.com";
        String password = "mysecretpassword";
        RequestSignUp requestSignUp = new RequestSignUp("Fatih Uyanık", 23,  email, username, password);
        testSignUp(requestSignUp, true);

        // ====================
        // Sign In User
        // ====================
        int NUM_OF_TEST_CASES = 4;
        RequestSignIn[] requests = {
                new RequestSignIn(email, password), // sign in with email
                new RequestSignIn(username, password),  // sign in with username
                new RequestSignIn("wrong", "wrong"), // sign in with wrong credentials
                new RequestSignIn("", "") // sign in with empty credentials
        };

        boolean[] expected = { true, true, false, false };
        for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
            testSignIn(requests[i], expected[i]);
        }
    }

    void testSignIn(RequestSignIn requestSignIn, boolean isExpectedToAuthenticate) {
        ResponseEntity<ResponseJwtAuth> responseSignIn = null;
        try { responseSignIn = contAuth.signIn(requestSignIn); }
        catch (Exception ignored) { }

        if (isExpectedToAuthenticate) {
            Assert.notNull(responseSignIn);
            Assert.notNull(responseSignIn.getBody().getAccessToken());
            Assert.notNull(responseSignIn.getBody().getUser());
        } else {
            Assert.isNull(responseSignIn);
        }
    }


    @Test
    void testRequestPasswordReset() throws Exception{
        repoUser.deleteAll();
        // Sign Up User
        String email = "fatih15@gmail.com";
        RequestSignUp requestSignUp = new RequestSignUp("Fatih Uyanık", 23,  email, "fatih", "mysecretpassword");
        testSignUp(requestSignUp, true);

        // ===========================
        // Request Password Reset
        // ===========================
        RequestPassword requestPassword = new RequestPassword(email);
        ResponseEntity<ResponsePasswordReset> reponse = contAuth.requestPasswordReset(requestPassword);
        Assert.notNull(reponse);
        Assert.notNull(reponse.getBody().getResetToken());

        // ===========================
        // Reset Password Reset
        // ===========================
        String newPassword = "newSecretPassword";
        String passwordResetToken = reponse.getBody().getResetToken();
        RequestResetPassword requestResetPassword = new RequestResetPassword(passwordResetToken, newPassword);
        ResponseEntity<ResponseOperation> response = contAuth.resetPassword(requestResetPassword);
        Assert.notNull(response);
        Assert.isTrue(response.getBody().getSuccess());
    }
}