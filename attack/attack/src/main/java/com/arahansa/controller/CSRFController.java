package com.arahansa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jarvis on 2017. 1. 29..
 */
@Slf4j
@Controller
public class CSRFController {

  @GetMapping("/csrf")
  public String csrf(){return "csrf";}


}
