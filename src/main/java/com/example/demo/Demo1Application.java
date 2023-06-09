package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.Errors.*;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class Demo1Application {

    private List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }


    @RequestMapping(value = "/sign-up", method = {RequestMethod.GET, RequestMethod.POST})
    public Object user(String username, String password, String password2) {

        int errorCode = Success;
        boolean success = false;
        if (username != null && username.length() > 0) {
            if (password != null && password.length() > 0) {
                if (password2 != null && password2.equals(password)) {
                    if (!this.userNameTaken(username)) {
                        User user = new User(username, password);
                        users.add(user);
                        success = true;
                    } else {
                        errorCode = ERROR_SIGN_UP_USERNAME_TAKEN;
                    }
                } else {
                    errorCode = ERROR_SIGN_UP_ON_PASSWORD_DONT_MATCH;
                }
            } else {
                errorCode = ERROR_SIGN_UP_ON_PASSWORD;
            }

        } else {
            errorCode = ERROR_SIGN_UP_ON_USERNAME;
        }
        return new BasicResponse(success, errorCode);
    }

    private boolean userNameTaken(String username) {
        boolean taken = false;
        for (User user : this.users) {
            if (user.isSameUserName(username)) {
                taken = true;
                break;
            }
        }
        return taken;
    }

    @RequestMapping(value = "/sign-in", method = {RequestMethod.GET, RequestMethod.POST})
    public Object login(String username, String password) {
        int errorCode = Success;
        boolean success = false;
        if (username != null && username.length() > 0) {
            if (password != null && password.length() > 0) {
                User user = this.getUser(username, password);
                if (user != null) {
                    success = true;
                } else {
                    errorCode = ERROR_LOGIN;
                }

            } else {
                errorCode = ERROR_SIGN_UP_ON_PASSWORD;
            }

        } else {
            errorCode = ERROR_SIGN_UP_ON_USERNAME;
        }
        return new BasicResponse(success, errorCode);
    }

    private User getUser(String username, String password) {
        User user = null;
        for (User currenUser : this.users) {
            if (currenUser.isSamePerson(username, password)) {
                user = currenUser;
                break;
            }
        }
        return user;
    }


}
