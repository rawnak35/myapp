package com.mytracker.users.controller;

import com.mytracker.users.dto.UserDto;
import com.mytracker.users.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// "services" - api requests
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Validated
public class UserController {
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
        UserDto savedUser = userService.getUserByUsername(username);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        UserDto savedUser = userService.getUserById(id);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String username,@Valid @RequestBody UserDto updatedUser) {
        UserDto userDto = userService.updateUser(username, updatedUser);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User was deleted successfully");
    }

}
