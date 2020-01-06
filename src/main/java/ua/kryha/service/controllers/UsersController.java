package ua.kryha.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kryha.service.forms.UserForm;
import ua.kryha.service.models.JUser;
import ua.kryha.service.services.UsersService;
import ua.kryha.service.transfer.UserDto;

import java.util.List;



@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return UserDto.from(usersService.findAll());
    }

    @GetMapping("/users/{user-id}")
    public JUser getUser(@PathVariable("user-id") Long userId) {
        return usersService.findOne(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm) {
        usersService.signUp(userForm);
        return ResponseEntity.ok().build();
    }
}
