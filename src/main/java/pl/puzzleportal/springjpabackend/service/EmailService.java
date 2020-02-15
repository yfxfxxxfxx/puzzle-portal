package pl.puzzleportal.springjpabackend.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject,
                           String text);
    void sendMessageWithAttachments(String to, String subject,
                                    String text, String pathToAttachment)
            throws MessagingException;
}
