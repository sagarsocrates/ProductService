package com.example.productservice.commons;

import com.example.productservice.dtos.UserDto;
import com.example.productservice.inheitancerespresentation.joinedtable.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        // CAll user service validate token API to validate
        ResponseEntity<UserDto> validateResponse =  restTemplate.postForEntity
                ("http://localhost:3030/users/validate/" + token, null, UserDto.class);

        if(validateResponse.getBody() == null){
            // token invalid
            return null;
        }
        return validateResponse.getBody();
    }
}
