package com.example.coronatracking.application;

import com.example.coronatracking.application.controller.ControllerAuth;
import com.example.coronatracking.application.controller.ControllerTrack;
import com.example.coronatracking.application.model.entity.EntityTrack;
import com.example.coronatracking.application.model.request.RequestId;
import com.example.coronatracking.application.model.request.RequestSignIn;
import com.example.coronatracking.application.model.request.RequestSignUp;
import com.example.coronatracking.application.model.request.RequestTrack;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponseTrack;
import com.example.coronatracking.application.repo.RepoTrack;
import com.example.coronatracking.application.repo.RepoUser;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnitTestsTrack {

    @Autowired
    private ControllerAuth contAuth;
    @Autowired
    private ControllerTrack contTrack;
    @Autowired
    private RepoTrack repoTrack;
    @Autowired
    private RepoUser repoUser;

    @BeforeAll
    public void setup() {
        // Sign Up User
        System.out.println("beforeeach");
        String name = "Fatih Sevban Uyanık";
        String password = "mysecretpassword";
        String email = "fatih15@gmail.com";
        String username = "fatih";
        Integer age = 23;

        RequestSignUp requestSignUp = new RequestSignUp(name, age,  email, username, password);
        RequestSignIn requestSignIn = new RequestSignIn(email, password);
        contAuth.signUp(requestSignUp);
        contAuth.signIn(requestSignIn);
    }


    @Test
    @Order(1)
    public void testCreateTrack() {
        RequestTrack requestTrack1 = new RequestTrack(
                true, false, true, true, false,
                false, false, false, false, false);

        RequestTrack requestTrack2 = new RequestTrack(false, true, true, true,
                true, false, true, true, true, true);

        testCreateTrack(requestTrack1);
        testCreateTrack(requestTrack2);
    }

    public void testCreateTrack(RequestTrack requestTrack) {
        ResponseEntity<ResponseOperation> response = contTrack.createTrack(requestTrack);
        Assert.notNull(response);
        Assert.isTrue(response.getBody().getSuccess());
    }

    @Test
    @Order(2)
    public void testGetTracks() {
        ResponseEntity<List<ResponseTrack>> response = contTrack.getTracks();
        List<ResponseTrack> responseList = response.getBody();
        Assert.notNull(responseList);
        Assert.isTrue(responseList.size() > 0);
    }

    @Test
    @Order(3)
    public void testDeleteTrack() {
        List<EntityTrack> tracks = repoTrack.findAll();
        for (EntityTrack track: tracks) {
            testDeleteTrack(track.getId());
        }
    }

    public void testDeleteTrack(Long id) {
        RequestId requestId = new RequestId(id);
        ResponseEntity<ResponseOperation> resOp = contTrack.deleteTrack(requestId);
        Assert.notNull(resOp);
        Assert.isTrue(resOp.getBody().getSuccess());
    }

    @AfterAll
    public void end() {
        // clear database
        repoTrack.deleteAll();
        repoUser.deleteAll();
    }

}
