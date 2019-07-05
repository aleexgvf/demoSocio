package com.example.demoSocios.controllers;

import com.example.demoSocios.applications.MembreciaApplication;
import com.example.demoSocios.domains.entities.Membrecia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/membrecias")
public class MembreciaController {
    @Autowired
    MembreciaApplication membreciaApplication;

    @PostMapping
    public Membrecia guardarMembrecia(@RequestBody Membrecia membrecia){
        return this.membreciaApplication.guardarMembrecia(membrecia);
    }

    @GetMapping(value = "{id}")
    public Membrecia buscarMembreciaPorId(@PathVariable Integer id) throws Exception {
        return this.membreciaApplication.buscarMembreciaPorId(id);
    }

    @GetMapping()
    public List<Membrecia> buscarTodasLasMembrecias() {
        return this.membreciaApplication.buscarTodasLasMembrecia();
    }

}
