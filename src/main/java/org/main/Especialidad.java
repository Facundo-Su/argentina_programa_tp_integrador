package org.main;
import javax.persistence.*;
@Entity
@Table(name = "especialidad")
public class Especialidad extends  EntidadPersistente {

    @Column(name = "nombre")
    private String nombre;

}
