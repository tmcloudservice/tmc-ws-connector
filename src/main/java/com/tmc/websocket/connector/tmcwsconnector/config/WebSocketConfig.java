package com.tmc.websocket.connector.tmcwsconnector.config;

import com.tmc.websocket.connector.tmcwsconnector.projects.TMCWSConnectorProjectsEnum;
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

    //TODO in which case is a good idea to open a completely new WS endpoint?
    //When there are a lot of files and we want to deploy faster the files
    //Or it is not very good idea because the WS connection overload the Network somehow
    //and also increase the CPU and memory (if you open a lot of WS connections it is possible
    // the performance to become slower than usual which is the best case ?)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        TMCWSConnectorProjectsEnum tmcwsConnectorProjectsEnum = new TMCWSConnectorProjectsEnum();
        for (int i = 0; i < tmcwsConnectorProjectsEnum.getAllProjectNames().size(); i++) {
            registry.addEndpoint("/gs-guide-websocket/"+ tmcwsConnectorProjectsEnum.getAllProjectNames().get(i));
        }
    }

}