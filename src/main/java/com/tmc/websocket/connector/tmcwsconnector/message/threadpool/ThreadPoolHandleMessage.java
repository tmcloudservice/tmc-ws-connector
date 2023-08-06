package com.tmc.websocket.connector.tmcwsconnector.message.threadpool;

import com.tmc.websocket.connector.tmcwsconnector.message.HandleMessage;
import com.tmc.websocket.connector.tmcwsconnector.message.Message;
import org.springframework.web.util.HtmlUtils;

public class ThreadPoolHandleMessage implements Runnable {

    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ThreadPoolHandleMessage(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new HandleMessage("TMC, " + HtmlUtils.htmlEscape(this.message.getName()) + "!");
    }
}
