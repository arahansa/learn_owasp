package com.arahansa.controller.owasp;

import com.arahansa.domain.User;
import com.arahansa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jarvis on 2017. 1. 10..
 */
@Slf4j
@RequestMapping("/owasp/sql_injection")
@Controller
public class O_01_SQLInjectionController {

  @Autowired
  DataSource dataSource;
  @Autowired
  UserRepository userRepository;

  @PostConstruct
  public void setup(){
    for(int i =0;i < 99;i++)
      userRepository.save(new User(Long.valueOf(i), "arahan"+i, "password"+i));
  }

  @GetMapping("/html")
  public String html(){
    return "owasp/sql_injection";
  }

  // http://stove99.tistory.com/99
  // https://blog.outsider.ne.kr/6
  // 파라미터로는 이걸 넣어주면 됨. .
  // final String encode = URLEncoder.encode("'1' OR '1'='1'", "UTF-8");
  @GetMapping("/bad")
  @ResponseBody
  public List<User> userList(String userid) throws SQLException {
    log.info("userList : param user Id: {}", userid);

    List<User> users = new ArrayList<>();

    try(Connection c = dataSource.getConnection();
        Statement stmt = c.createStatement()){
      ResultSet rs = stmt.executeQuery("select * from user where id =" + userid);
      while(rs.next()){
        User u = new User(rs.getLong("id"), rs.getString("name"), rs.getString("password"));
        log.info("user : {}", u);
        users.add(u);
      }
    }
    return users;
  }

  @GetMapping("/all")
  @ResponseBody
  public List<User> allList(){
    return userRepository.findAll();
  }
}
