package com.example.coronatracking.application.service;

import com.example.coronatracking.application.exception.ExceptionAuth;
import com.example.coronatracking.application.model.entity.EntityUser;
import com.example.coronatracking.application.model.request.RequestSignUp;
import com.example.coronatracking.application.model.response.ResponseJwtAuth;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponsePasswordReset;
import com.example.coronatracking.application.model.response.ResponseUser;
import com.example.coronatracking.application.repo.RepoUser;
import com.example.coronatracking.application.security.JwtTokenProvider;
import com.example.coronatracking.application.security.JwtUserDetail;
import com.example.coronatracking.application.util.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceUserImpl implements ServiceUser {

    private ModelMapper mapper;
    private final RepoUser repoUser;
    private AuthenticationManager authManager;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider tokenProvider;

    @Autowired
    public ServiceUserImpl(RepoUser repoUser, AuthenticationManager authManager, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        this.repoUser = repoUser;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public ResponseOperation signUp(RequestSignUp requestCreateUser) {
        // check whether username and email already exists.
        if(repoUser.existsByEmailOrUsername(requestCreateUser.getEmail(), requestCreateUser.getUsername())) {
            throw new ExceptionAuth("User already Exists");
        }

        // register the user.
        EntityUser entityUser = mapper.map(requestCreateUser, EntityUser.class);
        entityUser.setPassword(passwordEncoder.encode(entityUser.getPassword()));
        repoUser.save(entityUser);
        return new ResponseOperation(true, "User Signed Up", "CREATE");
    }

    @Override
    @Transactional
    public ResponseJwtAuth signIn(String usernameOrEmail, String password) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usernameOrEmail, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUserDetail jwtUserDetail = (JwtUserDetail) authentication.getPrincipal();
        EntityUser user = repoUser.findById(jwtUserDetail.getId()).get();
        String jwt = tokenProvider.generateToken(user.getId() + "", Constants.TOKEN_TYPE_AUTH);
        ResponseUser responseUser = mapper.map(user, ResponseUser.class);
        return new ResponseJwtAuth(jwt, responseUser);
    }

    @Override
    @Transactional
    public ResponsePasswordReset requestPasswordReset(String email) {
        Optional<EntityUser> optional = repoUser.findByEmail(email);
        if (!optional.isPresent()) {
            throw new RuntimeException("User not found");
        }

        EntityUser entityUser = optional.get();
        String token = tokenProvider.generateToken(
                entityUser.getId().toString(),
                Constants.TOKEN_TYPE_PASSWORD);
        entityUser.setPasswordResetToken(token);
        repoUser.save(entityUser);
        return new ResponsePasswordReset(token);
    }

    @Override
    @Transactional
    public boolean resetPassword(String passwordToken, String password) {
        boolean isTokenValid = tokenProvider.validateToken(passwordToken);
        if (!isTokenValid) return false;
        String encodedPassword = passwordEncoder.encode(password);
        Optional<EntityUser> user = repoUser.findByPasswordResetToken(passwordToken);
        if (!user.isPresent()) return false;
        user.get().setPassword(encodedPassword);
        user.get().setPasswordResetToken(null);
        repoUser.save(user.get());
        return true;
    }


    @Transactional
    public UserDetails loadUserById(Long id) {
        EntityUser user = repoUser.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        return JwtUserDetail.create(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        EntityUser user = repoUser.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found")
                );

        return JwtUserDetail.create(user);
    }
}
