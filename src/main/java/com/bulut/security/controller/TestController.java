package com.bulut.security.controller;

import com.bulut.security.service.DataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    DataGeneratorService dataGeneratorService;

    @GetMapping
    public ResponseEntity testEndPoint() {
        return new ResponseEntity(dataGeneratorService.getSampleData(), HttpStatus.ACCEPTED);
    }
}
