package com.arahansa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jarvis on 2017. 1. 10..
 */
@Entity
public class User {

  @Id
  @GeneratedValue
  Long id;
  String name;
  String password;

}
