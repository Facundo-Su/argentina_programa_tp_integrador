package org.main;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tecnico")
@Getter
@Setter
public class Tecnico extends EntidadPersistente{
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "id_especialidad")
    @ManyToMany()
    private List<Especialidad> especialidades;
    @OneToMany()
    private List<Incidente> incidenteAsignado;
    private Boolean disponibilidad;

    public Tecnico() {
        especialidades = new ArrayList<>();
        incidenteAsignado = new ArrayList<>();
    }

    public void asignarIncidente(Incidente incidente){
        if(especialidades.containsAll(incidente.getEspecialidades())){
            incidenteAsignado.add(incidente);
        }
    }
}
