package com.tmc.websocket.connector.tmcwsconnector.message;

public class HandleMessage {

    private String content;

    public HandleMessage() {
    }

    public HandleMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}