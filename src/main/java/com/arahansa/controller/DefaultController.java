package com.arahansa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jarvis on 2017. 1. 10..
 */
@Controller
public class DefaultController {


  @GetMapping("/")
  public String index(){return "index";}
}
