package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    @GetMapping("/ganna")
    public String showForm() {
        return "trial";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute Reg reg,Model model ) {
        System.out.println(reg.toString());
        return "trial";
    }
    
    
}
