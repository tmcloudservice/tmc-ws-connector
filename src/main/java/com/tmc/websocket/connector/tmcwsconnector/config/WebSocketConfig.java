package com.tmc.websocket.connector.tmcwsconnector.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private Map<String, Integer> stompRegistryEndPoints;

    public Map<String, Integer> getStompRegistryEndPoints() {
        return stompRegistryEndPoints;
    }

    public void setStompRegistryEndPoints(Map<String, Integer> stompRegistryEndPoints) {
        this.stompRegistryEndPoints = stompRegistryEndPoints;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/test");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        for (int i = 0; i < 10; i++) {
            registry.addEndpoint("/gs-guide-websocket"+ i);
        }
    }

}