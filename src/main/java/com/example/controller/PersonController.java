package com.example.controller;

import com.example.model.Person;
import com.example.model.User;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PersonController {
    @Value("${welcome.message}")
    private String message;

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllPersons")
    private ResponseEntity getAllPersons() {
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @GetMapping("/persons")
    private List<Person> getAllXPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @PostMapping("/persons")
    private int savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return person.getId();
    }
}