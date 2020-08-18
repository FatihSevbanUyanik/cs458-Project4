package com.example.coronatracking.application.controller;

import com.example.coronatracking.application.model.request.RequestPassword;
import com.example.coronatracking.application.model.request.RequestResetPassword;
import com.example.coronatracking.application.model.request.RequestSignIn;
import com.example.coronatracking.application.model.request.RequestSignUp;
import com.example.coronatracking.application.model.response.ResponseJwtAuth;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponsePasswordReset;
import com.example.coronatracking.application.service.interfaces.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class ControllerAuth {

    private ServiceUser serviceUser;

    @Autowired
    public ControllerAuth(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @PostMapping("/signIn")
    public ResponseEntity<ResponseJwtAuth> signIn(@RequestBody RequestSignIn requestSignIn) {
        String password = requestSignIn.getPassword();
        String usernameOrEmail = requestSignIn.getUsernameOrEmail();
        return ResponseEntity.ok(serviceUser.signIn(usernameOrEmail, password));
    }

    @PostMapping("/signUp")
    public ResponseEntity<ResponseOperation> signUp(@RequestBody RequestSignUp requestSignUp) {
        return ResponseEntity.ok(serviceUser.signUp(requestSignUp));
    }

    @PostMapping("/request-password-reset")
    public ResponseEntity<ResponsePasswordReset> requestPasswordReset(@RequestBody RequestPassword requestPassword) {
        return ResponseEntity.ok(serviceUser.requestPasswordReset(requestPassword.getEmail()));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ResponseOperation> resetPassword(@RequestBody RequestResetPassword requestResetPassword) {
        boolean isResetted = serviceUser.resetPassword(requestResetPassword.getPasswordToken(), requestResetPassword.getPassword());
        String info = isResetted ? "Password successfully changed." : "Password could not be updated.";
        return ResponseEntity.ok( new ResponseOperation(isResetted, info, "UPDATE") );
    }

}
