package com.arahansa.controller.etc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarvis on 2017. 1. 28..
 */
@Slf4j
@RequestMapping("/etc/fakejs")
@Controller
public class E_01_FakeJavascript {

  List<String> stringList = new ArrayList<>();

  @GetMapping
  public String list(Model model){
    return getString(model);
  }

  @PostMapping
  public String post(String msg, Model model){
    log.info("msg : {}", msg);
    stringList.add(msg);
    return getString(model);
  }

  private String getString(Model model) {
    model.addAttribute("list", stringList);
    return "owasp/csrf";
  }

}
