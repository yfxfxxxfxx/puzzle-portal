package pl.puzzleportal.springjpabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzleportal.springjpabackend.model.HelpMessage;
import pl.puzzleportal.springjpabackend.service.EmailService;

import java.util.logging.Logger;

@RestController
@RequestMapping("/help")
public class HelpController {

    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String destination;

    private Logger helpLogger = Logger.getLogger(getClass().getName());

    @PostMapping
    public void getMessage(@RequestBody HelpMessage message){

        helpLogger.info("Jestesmy w metodzie getMessage");
        helpLogger.info("Adres uzytkownika: " + message.getEmail());
        helpLogger.info("Wysylamy wiadomosc na adres " + destination);
        helpLogger.info("Wysylamy wiadomosc o tresci " + message.getMessageContent());

        String messageTemplate = ("%s \n\n Wiadomość od: %s");
        String messageArg = String.format(messageTemplate, message.getMessageContent(), message.getEmail());

        emailService.sendSimpleMessage(destination,
                message.getMessageType(),
                messageArg);
    }
}
