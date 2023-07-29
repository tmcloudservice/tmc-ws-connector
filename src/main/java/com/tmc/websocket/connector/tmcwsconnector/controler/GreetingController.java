package com.tmc.websocket.connector.tmcwsconnector.controler;

import com.tmc.websocket.connector.tmcwsconnector.message.Greeting;
import com.tmc.websocket.connector.tmcwsconnector.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("ws")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("TMC, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}