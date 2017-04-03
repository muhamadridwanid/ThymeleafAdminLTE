/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mridwan
 */
@Controller
public class TestController {
    
    @GetMapping("/")
    public String index(){
        return "welcome";
    }
}
