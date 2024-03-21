package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.User;
import de.uniba.dsam.group.project.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<User> getAllUsers(){
        System.out.println(this.userService.getAllUsers());
        return this.userService.getAllUsers();
    }


    @GetMapping({"/{userId}"})
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        User user = this.userService.getUserById(userId);
        return (user != null) ? new ResponseEntity<>(user, HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        boolean didDelete = this.userService.deleteUserById(userId);
        return didDelete ? new ResponseEntity<>("User Deleted successfully!", HttpStatus.OK):
                new ResponseEntity<>("Could not find the id.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long userId){
        boolean didUpdate = this.userService.updateUser(user, userId);
        return didUpdate ? new ResponseEntity<>("User updated successfully!", HttpStatus.OK):
                new ResponseEntity<>("User could not be updated.", HttpStatus.NOT_FOUND);
    }
}

