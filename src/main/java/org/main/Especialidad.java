package org.main;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "especialidad")
public class Especialidad extends  EntidadPersistente {

    @Column(name = "nombre")
    private String nombre;

}
