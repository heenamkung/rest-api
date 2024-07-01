package com.example.rest_api.controller;


import com.example.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // Post receives data with an object by default
    // POST http://localhost:8080/api/post with json body {"name" = "hee"} returns name=Hee, number=null, category=null
    @PostMapping("/post")
    // Return type string returns plain text. Return type BookRequest(object) will return a json
    public UserRequest post(
        // Default received data is Json. Receive json body and put inside bookRequest
        @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);
        //Returns snake case due to @JsonNaming at bookrequest.java
        return userRequest;
    }
}
