package com.example.smallbankapp.controller;

import com.example.smallbankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public String postUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model) {
        if (!userService.postUser(username, password)) {
            model.addAttribute("error", "error");
            return "registration";
        }
        return "login";
    }

    @GetMapping("/registration")
    public String openPage() {
        return "registration";
    }

  // @GetMapping("/index")
  // public String viewUserPage() {
  //     return "index";
  // }

}
