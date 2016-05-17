package com.se.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("/")
@CrossOrigin
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome!!!", HttpStatus.OK);
    }

}

