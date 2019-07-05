package com.example.demoSocios.applications;

import com.example.demoSocios.domains.entities.Membrecia;
import com.example.demoSocios.repositories.MembreciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreciaApplication{
    @Autowired
    MembreciaRepository membreciaRepository;

    // TODO: 05/07/2019 Metodo para guardar membrecia
    public Membrecia guardarMembrecia(Membrecia membrecia){
        return this.membreciaRepository.save(membrecia);
    }

    // TODO: 05/07/2019 Metodo para buscar una membrecia por id
    public Membrecia buscarMembreciaPorId(Integer id) throws Exception {
        if(id == null){
            throw new Exception("Id no puede ser nulo: " + id +".");
        }

        Membrecia membrecia = this.membreciaRepository.findOne(id);
        if (membrecia == null) {
            throw new Exception("Membrecia nula.");
        }
        return membrecia;
    }

    public List<Membrecia> buscarTodasLasMembrecia() {
        List<Membrecia> listaMembrecias =  this.membreciaRepository.findAll();
        return listaMembrecias;
    }
}
