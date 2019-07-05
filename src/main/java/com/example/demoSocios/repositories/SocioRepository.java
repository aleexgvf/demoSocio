package com.example.demoSocios.repositories;

import com.example.demoSocios.domains.entities.Socio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SocioRepository extends CrudRepository<Socio, Integer> {
    List<Socio> findAll();
    List<Socio> findByEdad(Integer edad);
    List<Socio> findByTipoMembrecia(Integer edad);
}
