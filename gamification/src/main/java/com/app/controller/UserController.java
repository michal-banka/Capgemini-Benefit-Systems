package com.app.controller;

import com.app.model.dto.UserDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        final String URL = "http://localhost:8081/api/user";
        ResponseEntity<UserDto[]> response
                = restTemplate.exchange(URL, HttpMethod.GET, null, UserDto[].class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        return Arrays.asList(response.getBody());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        final String URL = "http://localhost:8081/api/user/{id}";

        Map<String, String> params = new HashMap<>();
        params.put("id", id.toString());

        ResponseEntity<UserDto> response
                = restTemplate.exchange(URL, HttpMethod.GET, null, UserDto.class, params);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        return response.getBody();
    }

}
