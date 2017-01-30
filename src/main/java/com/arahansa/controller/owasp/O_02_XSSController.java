package com.arahansa.controller.owasp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jarvis on 2017. 1. 28..
 */
@Slf4j
@RequestMapping("/owasp/xss")
@Controller
public class O_02_XSSController {

  @GetMapping
  public String html(){
    return "owasp/xss";
  }

  @PostMapping
  public String post(String msg, Model model){
    log.debug("msg : {}", msg);
    model.addAttribute("msg", msg);
    return "owasp/xss";
  }

}
