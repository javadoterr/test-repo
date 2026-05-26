package com.javadoterr.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/v1/test")
@Slf4j
public class TestController {

    @GetMapping(path = "/hello")
    public ResponseEntity<?> greeting(){
        log.info("CONTROLLER : received request : METHOD : GET");
        return ResponseEntity.ok().body("Hey! This is test message : "
                + LocalDateTime.now().toString());
    }
}
