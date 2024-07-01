package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // REST api: returns JSON only
@Controller // returns HTML or other formats
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
    // <UserRequest> indicates Body type is UserRequest
    // ResponseEntity allows setting status code, header and body. Normally used for error handling
    // @RequestMapping(path = "", method = RequestMethod.GET) similar to GetMapping but without method= part, it will be available for all Get, Put, Post, Delete
    // Best to use specific GetMapping or RequestMapping(method=RequestMethod.GET)
    // @ ResponseBody: returns JSON when @Controller (not rest api)
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setUserName("Hee");
        user.setUserAge(10);
        user.setEmail("abc@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Status code 400
                .header("x-custom","hi")
                .body(user);

        return response;
    }
}
