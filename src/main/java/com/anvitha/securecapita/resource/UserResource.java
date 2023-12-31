package com.anvitha.securecapita.resource;

import com.anvitha.securecapita.domain.HTTPResponse;
import com.anvitha.securecapita.domain.User;
import com.anvitha.securecapita.dto.UserDTO;
import com.anvitha.securecapita.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

import static java.time.LocalTime.now;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<HTTPResponse> saveUser(@RequestBody @Valid User user){
        UserDTO userDto = userService.createUser(user);
        return  ResponseEntity.created(getUri())

                .body(HTTPResponse.builder().timeStamp(now().toString())
                        .data(Map.of("user",userDto))
                        .message("User Created")
                        .status(CREATED)
                        .statusCode(CREATED.value()).build());


    }

    private URI getUri() {
        return  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/get/<userId>").toUriString());

    }

}
