package org.main.repositorios;

import org.main.Servicio;
import org.main.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioServicio {

    public List<Tecnico> obtenerServicio(EntityManager entityManager){
        return entityManager.createQuery("from Servicio ").getResultList();
    }

    public void agregarServicio(Servicio servicio, EntityManager entityManager){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(servicio);
        tx.commit();
    }

    public void update(Servicio servicio, EntityManager entityManager){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(servicio);
        tx.commit();


    }
}
