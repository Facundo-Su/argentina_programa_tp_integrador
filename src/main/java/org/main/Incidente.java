package org.main;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incidente")
@Getter
@Setter
public class Incidente extends EntidadPersistente{
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="especialidad_id",referencedColumnName = "id")
    private List<Especialidad> especialidades;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio_id",referencedColumnName = "id")
    private Servicio servicio;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="tecnico_id",referencedColumnName = "id")
    private Tecnico tecnico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")
    private Cliente cliente;

    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }
    public Incidente() {
        this.especialidades = new ArrayList<>();
    }
}
