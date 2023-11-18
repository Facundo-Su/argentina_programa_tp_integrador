package org.main;


import javax.persistence.*;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadPersistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}