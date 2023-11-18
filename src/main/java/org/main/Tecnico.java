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
