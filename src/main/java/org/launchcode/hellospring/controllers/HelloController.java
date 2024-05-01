package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    // @GetMapping("hello") is replaced by...

    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
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
                        // "<form action = 'hello'>" + // submit a request to hello replaced by...
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name'>" +
                        "<input type = 'submit' value = 'Greet Me!'>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

}
