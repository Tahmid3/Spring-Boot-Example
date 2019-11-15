package com.example.repository;


import com.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepo extends CrudRepository<User, Long> {

    // findByUsername method for Spring Boot Security
    User findByUsername(String username);

}