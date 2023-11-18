package org.main;

import jakarta.persistence.*;

@Entity
@MappedSuperclass
public class EntidadPersistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}