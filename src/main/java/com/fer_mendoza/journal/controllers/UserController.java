package com.fer_mendoza.journal.controllers;

import com.fer_mendoza.journal.models.User;
import com.fer_mendoza.journal.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserSvc userSvc;

    @GetMapping("/")
    public List<User> index() {
        return userSvc.all();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable long id) {
        return userSvc.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        User createdUser= userSvc.createOrUpdate(user);
        if(createdUser == null){
            return ResponseEntity.notFound().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdUser);
    }

    @PutMapping("/")
    public ResponseEntity<User> update(@RequestBody User user){
        User createdUser = userSvc.createOrUpdate(user);
        if(createdUser == null){
            return ResponseEntity.notFound().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
        userSvc.delete(id);
        return ResponseEntity.noContent().build();
    }

}