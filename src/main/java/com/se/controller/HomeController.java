package com.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Clapa Lucian on 3/21/2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {
        return "Hello Spring World";
    }
}
