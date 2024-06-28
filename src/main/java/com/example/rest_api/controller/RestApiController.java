package com.example.rest_api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller that handles rest api
@RequestMapping("/api") // Handles all addresses that has /api
public class RestApiController {

    @GetMapping(path = "/hello") //When get method arrives at api/hello, this method is called
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}")
    public String echo(
            //@PathVariable String message // gets message from path {message}. the name MUST match with annotation
            @PathVariable(name="message") String msg // same as above but we can change variable name
    ){
        System.out.println("echo messsage : " + msg);
        return msg;
    }
}
