package com.example.springwebdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class IndexController {
    
    @GetMapping
    public String getGreeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
    model.addAttribute("messageName", name);
    return "greeting";
    }
}
