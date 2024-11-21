package com.alexandre.webService.resources;

import com.alexandre.webService.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping("/getAll")
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "James", "james@gmail.com", "jamie123", "42668964925");
        return ResponseEntity.ok().body(u);
    }

}
