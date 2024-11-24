package com.alexandre.webService.resources;

import com.alexandre.webService.entities.User;
import com.alexandre.webService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
//        Optional<User> obj = userService.findById(id);
//        return ResponseEntity.ok().body(obj);
        return new ResponseEntity<>(userService.findById(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User user){
        return new ResponseEntity<>(userService.insert(user), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
