package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class HelloController {
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam(defaultValue = "World") String coder,
                        @RequestParam(defaultValue = "en-us") String language){
        if ("en-us".equals(language)) {
            return "<h1>Hello " + coder.toUpperCase() + "!</h1>";
        } else if ("en-fr".equals(language)) {
            return "<h1>Bonjour " + coder.toUpperCase() + "!</h1>";
        } else if ("en-sp".equals(language)){
            return "<h1>Hola " + coder.toUpperCase() + "!</h1>";
        } else {
            return "<h1>Hello " + coder.toUpperCase() + "!</h1>";
        }
    }

    @GetMapping("/helloform")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body><h3>" +
                "<form action= '/' method='post'>" + //submit a request to /hello
                "<input type = 'text' name='coder'/>" +
             "<select name = 'language'>\n" +
                " <option value=\"en-fr\">French</option>\n" +
                " <option value=\"en-us\">English</option>\n" +
                " <option value=\"en-sp\">Spanish</option>\n" +
                "</select>" + "<input type = 'submit' value = 'Greet Me!' />" +
                "</body></h3>" +
                        "</form>" +
                        "</html>";
    }
}