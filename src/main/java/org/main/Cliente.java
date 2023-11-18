package org.main;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.main.MedioNotificado.MedioNotificado;

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente extends EntidadPersistente{

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "razonSocial")
    private String razonSocial;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "Incidente")
    @OneToMany()
    @JoinColumn(name="incidente_id" ,referencedColumnName = "id")
    private List<Incidente> IncidenteContratado;
    @Transient
    private MedioNotificado medioNotificado;

    public Cliente() {
    }


}
