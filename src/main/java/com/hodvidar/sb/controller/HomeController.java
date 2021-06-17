package com.hodvidar.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/variable")
    public String homePage2(Model model) {
        model.addAttribute("myvar", "Exercise SP 102 says hello");
        model.addAttribute("myvar2", "Hodvidar says hello too");
        return "variableTemplate";
    }

    @RequestMapping("/property")
    public String homePage3() {
         return "propertyTemplate";
    }


}
