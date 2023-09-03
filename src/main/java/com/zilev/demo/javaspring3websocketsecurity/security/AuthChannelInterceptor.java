package com.zilev.demo.javaspring3websocketsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthChannelInterceptor implements ChannelInterceptor {
    private final WebSocketAuthenticatorService service;
    private static final String TOKEN_HEADER = "X-Auth-Token";

    @Autowired
    public AuthChannelInterceptor(WebSocketAuthenticatorService service){
        this.service = service;
    }

    // Processes a message before sending it
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        // Instantiate an object for retrieving the STOMP headers
        final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        // Check that the object is not null
        assert accessor != null;
        // If the frame is a CONNECT frame
        if(accessor.getCommand() == StompCommand.CONNECT){
            final String token = accessor.getFirstNativeHeader(TOKEN_HEADER);
            // authenticate the user and if that's successful add their user information to the headers.
            UsernamePasswordAuthenticationToken user = service.getAuthenticationFromToken(token);
            accessor.setUser(user);
        }

        return message;
    }
}
