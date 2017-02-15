package com.arahansa.controller.owasp;

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
@RequestMapping("/owasp/csrf")
@Controller
public class O_03_CSRFController {

  // https://spring.io/blog/2015/06/08/cors-support-in-spring-framework


  // 크로스 사이트 요청 위조
  // CSRF : 웹사이트가 신뢰하지 않는 임의의 사용자로부터 인증되지 않은 명령이 전송되는 웹 사이트의 악의적인 착취 유형

  // CSRF 토큰이 보안조치이긴 하지만 완전하게 안전하진 않다
  // 공격 수행 스크립트가 웹사이트 자체에 있을 수도 있고 처음에 악의적인 스크립트로 공격을 당할 수 있다 (?)

  // 다음 조건들 중에서 일부가 충족되면 CSRF 가 수행될 수 있다
  // 방어하는 웹사이트가 referer 헤더를 확인하지 않는다.
  // 공격자가 필요로 하는 것


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

  @CrossOrigin(origins = "http://localhost:9090")
  @GetMapping("/rest")
  @ResponseBody
  public List<String> stringList(){
    return stringList;
  }


  private String getString(Model model) {
    model.addAttribute("list", stringList);
    return "owasp/csrf";
  }


}
