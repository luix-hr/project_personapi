package com.tceweb.project_personapi.repository;

import com.tceweb.project_personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
