package com.javadoterr.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/v1/test")
public class TestController {

    @GetMapping(path = "/hello")
    public ResponseEntity<?> greeting(){
        return ResponseEntity.ok().body("Hey! This is test message : "
                + LocalDateTime.now().toString());
    }
}
