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
public class Cliente extends EntidadPersistente {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "razonSocial")
    private String razonSocial;

    @Column(name = "cuit")
    private String cuit;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<Servicio> servicioContratado;

    @Column(name = "medioNotificado")
    @Convert(converter = MedioNotificadoConverter.class)
    private MedioNotificado medioNotificado;

    public Cliente() {
    }
}
