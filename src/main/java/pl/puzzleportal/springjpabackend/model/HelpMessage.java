package pl.puzzleportal.springjpabackend.model;

public class HelpMessage {

    private String messageType;
    private String messageContent;
    private String email;

    public HelpMessage() {
    }

    public HelpMessage(String messageType, String messageContent, String email) {
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.email = email;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
