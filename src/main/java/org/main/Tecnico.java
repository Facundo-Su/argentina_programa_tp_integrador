package org.main;

import javax.persistence.*;

import lombok.Setter;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tecnico")
@Getter
@Setter
public class Tecnico extends EntidadPersistente{
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Especialidad> especialidades;

    @Column(name = "disponibilidad")
    private Boolean disponibilidad;

    public Tecnico() {
        especialidades = new ArrayList<>();
    }

    public boolean puedeAdquidirElServicio(Servicio servicio){

        return this.especialidades.containsAll(servicio.getEspecialidadList());
    }

    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }
}
