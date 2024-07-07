package com.tempusmachina.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tempusmachina.app.config.Utils;
import com.tempusmachina.app.model.Profile;
import com.tempusmachina.app.service.ProfileService;


@RequestMapping("/signup")
@Controller
public class SignupController {
    
    @Autowired private Utils utils;
    @Autowired private ProfileService profileService;


    @GetMapping
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping
    public String signup(Profile profile) {

        profile.setPassword(utils.passwordEncoder().encode(profile.getPassword()));
        if (profileService.loadUserByUsername(profile.getEmail()).getPassword().equals(profile.getPassword())) {
            return "redirect:/signin?success";
        }

        return "redirect:/signin?error";
    }
}
