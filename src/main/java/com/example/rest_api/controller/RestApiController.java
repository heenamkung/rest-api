package com.example.rest_api.controller;


import com.example.rest_api.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

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

    // "is-man" because URL can't have capital letters
    @GetMapping(path = "/echo2/{message}/age/{age}/is-man/{isMan}")
    public String echo2(
            @PathVariable(name="message") String msg,
            @PathVariable int age, // age can be Integer or int. Integer can take null values. But URL never gets a null value, so use primitive type int.
            @PathVariable boolean isMan
    ){
        // http://localhost:8080/api/echo2/hello/age/15/is-man/true (true, false, 1, 0)
        System.out.println("echo messsage : " + msg);
        System.out.println("echo age : " + age);
        System.out.println("echo isMan : " + isMan);
        return msg.toUpperCase();
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    // Manual parsing - useful when there are few query parameters
    @GetMapping(path = "/book")
    public void queryParam(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam(name = "issued-month") String issuedMonth, //Java string can't have hyphen, so need to set name.
        @RequestParam(name = "issued_day") String issuedDay //
    ){
        System.out.println("Category: " + category);
        System.out.println("issuedYear: " + issuedYear);
        System.out.println("issuedMonth: " + issuedMonth);
        System.out.println("issuedDay: " + issuedDay);
    }

    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    // Receive data by an object - useful when they are many query parameters
    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }
}
