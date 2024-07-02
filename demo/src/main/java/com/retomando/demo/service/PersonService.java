package com.retomando.demo.service;

import com.retomando.demo.entities.PersonEntity;
import com.retomando.demo.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void createPerson(PersonEntity person){
        personRepository.save(person);
    }

    public List<PersonEntity> listPersons(){
        return personRepository.findAll();
    }

    Optional<PersonEntity>findPerson(String id){
        return personRepository.findById(id);
    }

    public void updatePerson(PersonEntity personEntity){
        personRepository.save(personEntity);
    }
    public void deletePerson(String id){
        personRepository.deleteById(id);
    }

}
