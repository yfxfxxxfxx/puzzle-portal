package pl.puzzleportal.springjpabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    public String retrieveUsers(){
        return null;
    }
}
