package com.test.crud.controller;

import com.test.crud.model.User;
import com.test.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String userPage(Model model) {
        List<User> userlist = userService.showUserList();
        model.addAttribute("userlist", userlist);
        return "user/user";
    }

    @GetMapping("/userlist")
    public String userList(Model model) {
        List<User> userlist = userService.showUserList();
        model.addAttribute("userlist", userlist);
        return "user/userlist";
    }

    @GetMapping("/addform")
    public String userAddForm() {

        return "user/useradd";
    }

    @PostMapping("/usersave")
    public String userSave(@ModelAttribute("datauser") User datauser) {
       userService.save(datauser);
       return "user/user";
    }

    @DeleteMapping("/userdelete/{id}")
    public String userDelete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return "user/userlist";
    }


}
