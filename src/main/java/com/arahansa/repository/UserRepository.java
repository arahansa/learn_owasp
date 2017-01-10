package com.arahansa.repository;

import com.arahansa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jarvis on 2017. 1. 10..
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
