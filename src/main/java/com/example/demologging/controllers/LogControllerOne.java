package com.example.demologging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demologging.services.LogService;

@RestController
public class LogControllerOne {

    @Autowired
    private LogService logService;

    @PostMapping("/changeloglevel")
    public String changeLogLevel(@RequestParam(required = false) String loggerName,
                                 @RequestParam(required = false) String level) {
        return logService.setLoglevel(loggerName, level);
    }
}