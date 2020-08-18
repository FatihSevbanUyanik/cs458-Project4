package com.example.coronatracking.application.service.interfaces;

import com.example.coronatracking.application.model.request.RequestSignUp;
import com.example.coronatracking.application.model.response.ResponseJwtAuth;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponsePasswordReset;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ServiceUser extends UserDetailsService {
    ResponseOperation signUp(RequestSignUp requestCreateUser);
    ResponseJwtAuth signIn(String usernameOrEmail, String password);
    boolean resetPassword(String passwordToken, String password);
    ResponsePasswordReset requestPasswordReset(String email);
}
