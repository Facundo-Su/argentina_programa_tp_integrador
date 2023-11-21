package org.main.repositorios;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.main.EntidadPersistente;
import org.main.Tecnico;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioTecnico  {


    public List<Tecnico> obtenerTecnicos(EntityManager entityManager){
        return entityManager.createQuery("from Tecnico ").getResultList();
    }

    public void agregarTecnico(Tecnico tecnico, EntityManager entityManager){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(tecnico);
        tx.commit();
    }

}
