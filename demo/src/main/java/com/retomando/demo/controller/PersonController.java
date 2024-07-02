package com.retomando.demo.controller;

import com.retomando.demo.entities.PersonEntity;
import com.retomando.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody PersonEntity person){
        personService.createPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping(value = "list")
    public List<PersonEntity> personEntityList(){
        return personService.listPersons();

    }



}
