package com.example.ExpensesTracked_Backend;

import com.example.ExpensesTracked_Backend.service.imp.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
/**
 * Chat Controller Class
 */
@Controller
public class ChatController {

	/**
	 * method that sends message in the chat session
	 * 
	 * @param chatMessage
	 * @return chatMessage
	 */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    /**
     * method that adds user into the online chat session
     * 
     * @param chatMessage
     * @param headerAccessor
     * @return chatMessage
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}