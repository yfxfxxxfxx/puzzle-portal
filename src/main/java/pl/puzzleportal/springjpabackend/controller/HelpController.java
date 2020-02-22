package pl.puzzleportal.springjpabackend.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pl.puzzleportal.springjpabackend.entity.HelpMessage;
import pl.puzzleportal.springjpabackend.repository.HelpMessageRepository;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/help")
public class HelpController {

   private HelpMessageRepository helpMessageRepository;
   private Logger logger;

    public HelpController(HelpMessageRepository helpMessageRepository) {
        this.helpMessageRepository = helpMessageRepository;
        this.logger = Logger.getLogger(getClass().getName());
    }

    @PostMapping
    public HelpMessage saveMessage(@RequestBody HelpMessage message){
        logger.info(message.toString());
        Preconditions.checkNotNull(message);
        return helpMessageRepository.save(message);
    }

    @GetMapping("/admin")
    public List<HelpMessage> displayMessages() {
        return helpMessageRepository.findAll();
    }
}
