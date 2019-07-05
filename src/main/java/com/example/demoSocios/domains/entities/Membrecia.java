package com.example.demoSocios.domains.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicUpdate
@DynamicInsert
@Entity(name = "membrecias")
@Table(name = "membrecias")
public class Membrecia {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        @Column(name = "tipomembrecia")
        private String tipoMembrecia;
}
