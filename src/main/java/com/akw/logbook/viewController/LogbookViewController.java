package com.akw.logbook.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogbookViewController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

}
