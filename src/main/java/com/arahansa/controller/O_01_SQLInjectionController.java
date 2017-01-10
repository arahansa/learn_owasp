package com.arahansa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jarvis on 2017. 1. 10..
 */
@RequestMapping("/owasp/sql_injection")
@Controller
public class O_01_SQLInjectionController {


  @GetMapping("/html")
  public String html(){
    return "owasp/sql_injection";
  }



}
