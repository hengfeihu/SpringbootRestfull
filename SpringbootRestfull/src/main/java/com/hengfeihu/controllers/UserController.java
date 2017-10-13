package com.hengfeihu.controllers;

import com.hengfeihu.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hengfeihu on 2017/10/13.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<User> list() {
        return User.db().find(User.class).findList();
    }
}
