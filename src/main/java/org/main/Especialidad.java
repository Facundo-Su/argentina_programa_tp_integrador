package org.main;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad extends  EntidadPersistente {

    @Column(name = "nombre")
    private String nombre;

}
