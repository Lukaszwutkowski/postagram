package com.postagram.controller;

import com.postagram.domain.CurrentUser;
import com.postagram.domain.GenericResponse;
import com.postagram.domain.User;
import com.postagram.domain.vm.UserVM;
import com.postagram.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/users")
    GenericResponse createUser(@Valid @RequestBody User user) {
       userService.save(user);
       return new GenericResponse("User saved");
    }

    @GetMapping("/users")
    Page<UserVM> getUsers(@CurrentUser User loggedInUser, Pageable page) {
        return userService.getUsers(loggedInUser, page).map(UserVM::new);
    }

    @GetMapping("/users/{username}")
    UserVM getUserByName(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return new UserVM(user);
    }
}
