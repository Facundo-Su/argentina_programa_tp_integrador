package org.main;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio")
@Getter
@Setter
public class Servicio extends EntidadPersistente{

    @Column (name ="nombre")
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="especialidad_id",referencedColumnName = "id")
    private List<Especialidad> especialidadList;


    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidadList.add(especialidad);
    }

    public Servicio() {
        this.especialidadList = new ArrayList<>();
    }
}
