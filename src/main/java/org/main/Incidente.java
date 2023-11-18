package org.main;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incidente")
@Getter
@Setter
public class Incidente extends EntidadPersistente{
@Transient
   // @ManyToMany()
    private List<Especialidad> especialidades;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Column(name = "fechaPosibleFinalizacion")
    private Date fechaPosibleFinalizacion;
    @Column(name = "fechaFinalizacion")
    private Date fechaFinalizacion;

    @Column(name = "resuelto")
    private boolean resuelto;

    @Transient
    //@ManyToOne
    //@JoinColumn(name ="tecnico_id",referencedColumnName = "id")
    private Tecnico tecnico;

    public Incidente() {
    }
}
