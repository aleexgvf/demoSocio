package com.example.demoSocios.repositories;

import com.example.demoSocios.domains.entities.Membrecia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MembreciaRepository extends CrudRepository<Membrecia, Integer> {
    List<Membrecia>findAll();
}
