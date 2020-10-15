package com.quercusdata.awsspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HelloWorldWS {

    private Logger log	= LoggerFactory.getLogger(HelloWorldWS.class);

    @GetMapping({"/", "hello"})
    public String helloWorld(
            @RequestParam(required = false, defaultValue = "World") String name,
            @RequestParam(required = false, defaultValue = "") String gender,
            Model model) {

        log.debug("Entering. name:{} gender:{}", name, gender);
        String salute = "";
        if(!("").equals(gender)) {
            salute = ("male".equals(gender) ? "Mr " : "Mrs ");
        }
        model.addAttribute("name", name);
        model.addAttribute("gender", salute);
        log.debug("Leaving");
        return "hello-world";
    }
}
