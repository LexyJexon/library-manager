package com.example.librarymanager.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String adminLogin, @RequestParam String adminPass, Model model){
        if(adminLogin.equals("admin") && adminPass.equals("adminlibrary")){
            return "redirect:/library/add";
        }
        else return "home";
    }


    @GetMapping("/")
    public String home(@NotNull Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }

}