package com.akw.logbook.viewController;

import com.akw.logbook.user.UserDTO;
import com.akw.logbook.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register_form";     //the name of template
    }

    @PostMapping("/process_register")
    public String showRegistrationMessage(UserDTO userDTO) {
        userService.registerUser(userDTO);
        return "register_success";   //the name of template
    }
}
