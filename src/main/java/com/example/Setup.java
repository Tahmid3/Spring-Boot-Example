package com.example;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class Setup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
   private UserRepo repo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User admin = new User("admin", "admin", true, Role.ADMIN);

        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        repo.save(admin);
    }

}
