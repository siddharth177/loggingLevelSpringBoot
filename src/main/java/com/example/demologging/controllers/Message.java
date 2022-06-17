package com.example.demologging.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Message {

    Logger logger = LoggerFactory.getLogger(Message.class.getName());

    @GetMapping("/message")
    public String hello() {
        logger.error("Error log level"); // trace is'nt configured yet so we need to set level in application.properties
        logger.warn("Warn log level");
        logger.info("Info log level");
        logger.debug("Debug log level");
        logger.trace("Trace log level");
        return "HELLO WORLD LOGGING DEMO";
    }
}
