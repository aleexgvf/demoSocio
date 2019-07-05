package com.example.demoSocios.applications;

import com.example.demoSocios.domains.entities.Membrecia;
import com.example.demoSocios.domains.entities.Socio;
import com.example.demoSocios.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioApplication {
    @Autowired
    SocioRepository socioRepository;

    @Autowired
    MembreciaApplication membreciaApplication;

    public Socio guardarSocio(Socio socio) throws Exception {
        this.socioRepository.save(socio);
        this.asignarMembreciaASocio(socio);
        return socio;
    }

    public Socio buscarSocioPorId(Integer id) throws Exception {
        if(id == null)
        {
            throw new Exception("Id dada es nula: " + id + ".");
        }

        Socio socio = this.socioRepository.findOne(id);
        this.asignarMembreciaASocio(socio);
        if(socio == null) {
            throw new Exception("socio no existe.");
        }
        return socio;
    }

    public List<Socio> buscarTodosLosSocios() throws Exception {
        List<Socio> listaSocios = this.socioRepository.findAll();
        if(listaSocios.isEmpty()) {
            throw new Exception("Lista de Socios vacia.");
        }

        listaSocios.forEach(socio -> {
            try{
                this.asignarMembreciaASocio(socio);
            }catch(Exception e){
                System.out.println(e);
            }
        });
        return listaSocios;
    }

    public List<Socio> buscarSocioPorEdad(Integer edad) throws Exception {
        List<Socio> listaSocio = this.socioRepository.findByEdad(edad);
        if(listaSocio.isEmpty()){
            throw new Exception("Edad no encontrada.");
        }

        listaSocio.forEach(socio -> {
            try{
                this.asignarMembreciaASocio(socio);
            }catch(Exception e){
                System.out.println(e);
            }
        });
        return listaSocio;
    }

    // TODO: 05/07/2019 Metodo para asignar objeto de tipo membrecia a un Objeto de tipo socio
    private Socio asignarMembreciaASocio(Socio socio) throws Exception {
       if(socio == null){
           throw new Exception("Socio nulo.");
       }

        Membrecia membrecia = this.membreciaApplication.buscarMembreciaPorId(socio.getTipoMembrecia());
        if(membrecia == null) {
            throw new Exception("Membrecia nula.");
        }
        socio.setMembrecia(membrecia);
        return socio;
    }

    public List<Socio> buscarSociosPorMembresia(Integer tipoMembresia) throws Exception {
        List<Socio> listaSocio = this.socioRepository.findByTipoMembrecia(tipoMembresia);
        if(listaSocio.isEmpty()){
            throw new Exception("Edad no encontrada.");
        }

        listaSocio.forEach(socio -> {
            try{
                this.asignarMembreciaASocio(socio);
            }catch(Exception e){
                System.out.println(e);
            }
        });
        return listaSocio;
    }
}
