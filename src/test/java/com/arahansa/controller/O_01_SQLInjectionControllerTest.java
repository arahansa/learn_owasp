package com.arahansa.controller;

import org.junit.Test;

import java.net.URLEncoder;

import static org.junit.Assert.*;

/**
 * Created by jarvis on 2017. 1. 11..
 */
public class O_01_SQLInjectionControllerTest {

  @Test
  public void encode() throws Exception{
    assertEquals(1,1);

    final String encode = URLEncoder.encode("'1' OR '1'='1'", "UTF-8");
    System.out.println("encode : "+encode);


  }

}