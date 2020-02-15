package pl.puzzleportal.springjpabackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help")
public class HelpController {

    @PostMapping
    public void getMessage(@RequestBody String message){
        System.out.println(message);
    }
}
