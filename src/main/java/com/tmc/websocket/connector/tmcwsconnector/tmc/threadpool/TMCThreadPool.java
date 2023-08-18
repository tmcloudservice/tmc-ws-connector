package com.tmc.websocket.connector.tmcwsconnector.tmc.threadpool;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
public class TMCThreadPool {

    @Value("${tmc.thread.pool}")
    private String tmcThreadPool;

    public void setTmcThreadPool(String tmcThreadPool) {
        this.tmcThreadPool = tmcThreadPool;
    }

    public String getTmcThreadPool() {
        return tmcThreadPool;
    }

    /*   public TMCThreadPool(@Value("${tmc.thread.pool}") int tmcThreadPool) {
                    this.tmcThreadPool = tmcThreadPool;
                }*/
 /*  public TMCThreadPool(){
       new TMCThreadPool(2);
   }*/
 /*   public TMCThreadPool(@Value("${tmc.thread.pool:6}") int tmcThreadPool) {
        this.tmcThreadPool = tmcThreadPool;
    }*/
    public void printThreadPool(){
        System.out.println(tmcThreadPool);
    }
}
