package com.tceweb.project_personapi.controller;

import com.tceweb.project_personapi.dto.request.PersonDTO;
import com.tceweb.project_personapi.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody @Valid PersonDTO personDTO){
        personDTO = personService.insert(personDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(personDTO.getId()).toUri();
        return ResponseEntity.created(uri).body("Created person with ID " + personDTO.getId());

    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listAll(){
        var list = personService.listAll();
        return ResponseEntity.ok(list);
    }
}
