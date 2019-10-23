package com.example.rest;

import com.example.model.User;
import com.example.model.UserToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {

    private List<User> userList = new LinkedList<>();

    @RequestMapping(method = RequestMethod.POST, value = "/newUser")
    private ResponseEntity newUser(@RequestBody UserToDo newUser) {

        if (newUser.getFirstName().matches("[\\w- ]+")) {

            User user = new User();
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            userList.add(user);

            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    private ResponseEntity getAllUsers() {
        return ResponseEntity.ok().body(userList);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/delUser/{firstName}")
    private ResponseEntity delUser(@PathVariable String firstName) {

        for (User cUser : userList) {
            if (cUser.getFirstName().equals(firstName)) {
                userList.remove(cUser);
                return ResponseEntity.ok().body(null);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }
}
