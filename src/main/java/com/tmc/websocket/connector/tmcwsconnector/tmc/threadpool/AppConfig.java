package com.tmc.websocket.connector.tmcwsconnector.tmc.threadpool;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.tmc.websocket.connector.tmcwsconnector.tmc.threadpool"})
@PropertySource(name = "props", value = "application.properties")
public class AppConfig { }