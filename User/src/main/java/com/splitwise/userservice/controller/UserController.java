package com.splitwise.userservice.controller;

import com.splitwise.userservice.entity.User;
import com.splitwise.userservice.pojo.LoginRequestDTO;
import com.splitwise.userservice.pojo.UserDetailsDTO;
import com.splitwise.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable int id){
        User user = userService.findByID(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserDetailsDTO userDetailDTO){
        User user = userService.createUser(userDetailDTO);

      return ResponseEntity.ok("Created Sucessfully \n" + user);
    }

    @PatchMapping("/{userId}/updateGroup/{groupId}")
    public ResponseEntity<?> updateGroupList(@PathVariable int userId, @PathVariable int groupId){
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok("DOne");
    }

}
