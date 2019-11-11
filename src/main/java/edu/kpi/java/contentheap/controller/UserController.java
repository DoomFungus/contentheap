package edu.kpi.java.contentheap.controller;

import edu.kpi.java.contentheap.message.UserDTO;
import edu.kpi.java.contentheap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody String name){
        userService.saveUser(name);
    }

    @GetMapping(value = "/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{name}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<UserDTO> getUser(@PathVariable String name){
        return userService.getUser(name);
    }
}
