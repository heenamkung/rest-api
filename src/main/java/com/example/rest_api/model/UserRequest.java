package com.example.rest_api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//When receving data, snake case data (user_name) are mapped to camel case (userName).
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    private String userName;

    private Integer userAge;

    private String email;

    //Don't use primitive type boolean. #1. if null, isKorean is set to default value false.
    // #2. lombok will change setter to setKorean not setIsKorean when using primitive boolean and "is" keyword.
    // results in isKorean always being false.
    private Boolean isKorean;
}
