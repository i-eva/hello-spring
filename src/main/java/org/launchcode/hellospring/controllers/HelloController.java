package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {
    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String Hello() {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye")
    @ResponseBody
    public String Goodbye() {
        return "Goodbye, Spring!";
    }

    // Responds to get requests at /hello?name=LaunchCode
    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Responds to (handles) get requests (of a form) at /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParameter(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form action = 'hello'>" + // submit a request to hello
                        "<input type = 'text' name = 'name'>" +
                        "<input type = 'submit' value = 'Greet Me!'>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

}
