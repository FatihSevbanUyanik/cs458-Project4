package com.example.coronatracking.application;

import com.example.coronatracking.application.controller.ControllerAuth;
import com.example.coronatracking.application.model.request.RequestPassword;
import com.example.coronatracking.application.model.request.RequestResetPassword;
import com.example.coronatracking.application.model.request.RequestSignIn;
import com.example.coronatracking.application.model.request.RequestSignUp;
import com.example.coronatracking.application.model.response.ResponseJwtAuth;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponsePasswordReset;
import com.example.coronatracking.application.repo.RepoUser;
import com.example.coronatracking.application.security.JwtTokenProvider;
import com.example.coronatracking.application.service.ServiceUser;
import io.jsonwebtoken.lang.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ControllerAuth cont_auth;

    @Test
    void testSignIn() throws Exception{
        trySignIn("selen", "123");
        trySignIn("fatih", "naruto21602486");
    }

    void trySignIn(String username, String password)
    {
        RequestSignIn req_sin = new RequestSignIn(username, password);
        Assert.notNull(cont_auth.signIn(req_sin));
    }

    @Test
    void testSignUp() throws Exception{
        trySignUp("selen", 21, "selen@gmail.com", "selen", "123");
        trySignUp("deniz", 26, "deniz@gmail.com", "deniz", "abc");
    }

    void trySignUp(String name, int age, String email, String username, String password){
        RequestSignUp req_sup = new RequestSignUp(name, age, email, username, password);
        Assert.notNull(cont_auth.signUp(req_sup));
    }

    @Test
    void testRequestPasswordReset() throws Exception{
        tryReqPassRes("selen@gmail.com");
        tryReqPassRes("fatihsevban@gmail.com");
    }

    void tryReqPassRes(String email){
        RequestPassword req_pass = new RequestPassword(email);
        Assert.notNull(cont_auth.requestPasswordReset(req_pass));
    }

    @Test
    void testResetPassword() throws Exception{
        tryResetPassword("arfawf", "sel");
        tryResetPassword("dtyjtyj", "123");
    }

    void tryResetPassword(String passwordToken, String password){
        RequestResetPassword req_resPass = new RequestResetPassword(passwordToken, password);
        Assert.notNull(cont_auth.resetPassword(req_resPass));
    }
}
