package com.tmc.websocket.connector.tmcwsconnector.controler;

import com.tmc.websocket.connector.tmcwsconnector.message.HandleMessage;
import com.tmc.websocket.connector.tmcwsconnector.message.Message;
import com.tmc.websocket.connector.tmcwsconnector.message.threadpool.ThreadPoolHandleMessage;
import com.tmc.websocket.connector.tmcwsconnector.threadmonitor.ThreadMonitor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    private static int stmompClientCouter;

    @MessageMapping("ws")
    @SendTo("/topic/greetings")
    public HandleMessage greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        if (stmompClientCouter > 5){
            stmompClientCouter = 0;
            System.out.println("Enter into if statement");

            Thread t1 = new Thread(new ThreadPoolHandleMessage(message));
            t1.start();
            startThreadMonitor(Thread.currentThread());
        }
        else {
            System.out.println("Enter into else statement");
            stmompClientCouter++;
            startThreadMonitor(Thread.currentThread());
            return new HandleMessage("TMC, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        }
        return new HandleMessage("TMC, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    public void startThreadMonitor(Thread thread){
        ThreadMonitor threadMonitor = new ThreadMonitor();
        threadMonitor.showThreadStatus(Thread.currentThread());
    }
}