package com.example.demologging.controllers;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogControllerTwo {
    @PostMapping("/changelevel")
    public String changeLogLevel(@RequestParam(required = false) String loggerName,
                                 @RequestParam(required = false) String level) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger logger = loggerName.equalsIgnoreCase("root")?
                loggerContext.getLogger(loggerName):loggerContext.exists(loggerName);
        if( logger !=null){
            logger.setLevel(Level.toLevel(level));
            return "Changed logger: "+loggerName+" to level : "+level;
        } else {
            return "Logger Not Found Make Sure that logger name is correct";
        }
    }

}
