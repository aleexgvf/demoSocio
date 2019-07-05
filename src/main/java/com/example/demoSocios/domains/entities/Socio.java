package com.example.demoSocios.domains.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicInsert
@DynamicUpdate
@Entity(name = "socios")
@Table(name = "socios")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "apellidopaterno")
    String apellidoPaterno;

    @Column(name = "apellidomaterno")
    String apellidoMaterno;

    @Column(name =  "direccion")
    String direccion;

    @Column(name = "edad")
    Integer edad;

    @Column(name = "tipomembrecia")
    Integer tipoMembrecia;

    @Transient
    Membrecia membrecia;
}
