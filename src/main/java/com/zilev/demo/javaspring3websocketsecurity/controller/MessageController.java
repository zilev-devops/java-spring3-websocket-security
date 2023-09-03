package com.zilev.demo.javaspring3websocketsecurity.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String handle(String greeting) {
        return "[hols: " + greeting;
    }
}
