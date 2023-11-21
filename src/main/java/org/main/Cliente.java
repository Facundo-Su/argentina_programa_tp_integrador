package org.main;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.main.MedioNotificado.MedioNotificado;
import org.main.converter.MedioNotificadoConverter;

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
    @OneToMany(cascade =CascadeType.ALL , mappedBy = "cliente",orphanRemoval = true)
    private List<Incidente> IncidenteContratado;
    @Column(name = "medioNotificado")

    @Convert(converter = MedioNotificadoConverter.class)
    private MedioNotificado medioNotificado;

    public Cliente() {
    }


}
