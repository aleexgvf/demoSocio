package com.example.demoSocios.controllers;

import com.example.demoSocios.applications.SocioApplication;
import com.example.demoSocios.domains.entities.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/socios")
public class SocioController {
    @Autowired
    SocioApplication socioApplication;

    @PostMapping
    public Socio guardarSocio(@RequestBody Socio socio) throws Exception {
        return this.socioApplication.guardarSocio(socio);
    }

    @GetMapping(value = "{id}")
    public Socio buscarSocioPorId(@PathVariable Integer id) throws Exception {
        return this.socioApplication.buscarSocioPorId(id);
    }

    @GetMapping()
    public List<Socio> buscarTodosLosSocios() throws Exception {
        return this.socioApplication.buscarTodosLosSocios();
    }

    @GetMapping(value = "edad/{edad}")
    public List<Socio> buscarSocioPorEdad(@PathVariable Integer edad) throws Exception {
        return this.socioApplication.buscarSocioPorEdad(edad);
    }

    @GetMapping(value = "membrecia/{tipoMembresia}")
    public List<Socio> buscarSocioPorTipoMembresia(@PathVariable Integer tipoMembresia) throws Exception {
        return this.socioApplication.buscarSociosPorMembresia(tipoMembresia);
    }


}
