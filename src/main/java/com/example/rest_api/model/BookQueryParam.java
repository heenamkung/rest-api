package com.example.rest_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data //getter setter made from lombok
@AllArgsConstructor // Creates constructor with all 4 variables as parameter
@NoArgsConstructor // Creates constructor without any parameter
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

}
