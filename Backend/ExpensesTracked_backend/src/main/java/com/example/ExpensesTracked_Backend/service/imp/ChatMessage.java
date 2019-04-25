package com.example.ExpensesTracked_Backend.service.imp;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    /**
     * returns the type of message
     * @return type
     */
    public MessageType getType() {
        return type;
    }

    /**
     * sets the type of message to chat, join, or leave
     * @param type
     */
    public void setType(MessageType type) {
        this.type = type;
    }

    /**
     * gets content of the message
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * sets the content of the message 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * returns who sent the message
     * @return sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * sets the sender of the message
     * @param sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
}