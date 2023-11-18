package org.main;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "incidente")
@Getter
@Setter
public class Incidente extends EntidadPersistente{

    @ManyToMany()
    private List<Especialidad> especialidades;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaInicio")
    private LocalDateTime fechaInicio;
    @Column(name = "fechaInicio")
    private LocalDateTime fechaPosibleFinalizacion;
    @Column(name = "fechaInicio")
    private LocalDateTime fechaFinalizacion;
    @Column(name = "fechaInicio")
    private boolean resuelto;

    @ManyToOne
    @JoinColumn(name ="tecnico_id",referencedColumnName = "id")
    private Tecnico tecnico;

    public Incidente() {
    }
}
