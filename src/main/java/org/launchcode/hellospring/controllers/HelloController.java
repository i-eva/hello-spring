package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String Hello() {
//        return "Hello, Spring!";
//    }

    // pulled responsebody and requestmapping up to class level
    // now the method below lives at /hello/goodbye
    @GetMapping("goodbye")
    public String Goodbye() {
        return "Goodbye, Spring!";
    }

    // Responds to get requests at /hello?name=LaunchCode
    // @GetMapping("hello") is replaced by...

    // Responds to get and post requests at /hello?coder=LaunchCoder
    // lives at hello/hello with changes at the class level
    // and able to remove value = "hello" from requestmapping below
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Responds to (handles) get requests (of a form) at /hello/LaunchCode
    // able to remove hello/ from getmapping, below
    @GetMapping("{name}")
    public String helloWithPathParameter(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    // lives at /hello/form with changes at class level
    @GetMapping
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
