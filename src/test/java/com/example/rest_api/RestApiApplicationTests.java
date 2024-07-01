package com.example.rest_api;

import com.example.rest_api.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired // Spring automatically creates an instance of this class and manages it. In this case, objectMapper
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setUserName("Hee");
		user.setUserAge(10);
		user.setEmail("abc@gmail.com");
		user.setIsKorean(true);

		// *WARNING* When serializing, object mapper only serializes value from that has method name starting with 'get'.
		// Lombok created getters and setters so there's no problem with lombok. However, when we define getters ourselves,
		// if there is no getUserName(), user_name will not be serialized to json (json will not contain "user_name" : "hee")
		// If there is another method named getName() that returns userName, then json will have two fields that return userName (UserName and Name).
		// To prevent this, use annotation @JsonIgnore to getName() to prevent it from getting serialized.
		var json = objectMapper.writeValueAsString(user);
		System.out.println(json);

		//@JsonProperty: when receiving or sending JSON with custom syntax (such as all uppercase EMAIL)
		// we can set @JsonProperty("EMAIL") on "private String email;" to send or receive json { "EMAIL" : "abc@gmail.com" }

		// 1. Object mapper can create instance of UserRequest even if the constructor is private.
		// 2. When reading json (deserialize), dto must contain EITHER setter or getter to work properly.
		// Without getter or setter (named correctly: "getUserName", "setEmail"), dto will be an UserRequest object with all members set to null.
		// 3. Json suddenly with a "userNames":"Hee" will cause userName to be null. Fix this by adding @JsonProperty("user_names") to "private String username"
		// Also can create SetUserNames(String name){ this.userName = name; } to map it correctly
		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);
	}

}
