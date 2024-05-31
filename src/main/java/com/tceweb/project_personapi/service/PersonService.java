package com.tceweb.project_personapi.service;

import com.tceweb.project_personapi.dto.request.PersonDTO;
import com.tceweb.project_personapi.entity.Person;
import com.tceweb.project_personapi.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PersonDTO insert(PersonDTO personDTO){
        Person person = modelMapper.map(personDTO, Person.class);
        return modelMapper.map(personRepository.save(person), PersonDTO.class);
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream().map(PersonDTO::new).collect(Collectors.toList());
    }
}
