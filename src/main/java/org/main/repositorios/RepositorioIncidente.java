package org.main.repositorios;

import org.main.Incidente;
import org.main.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioIncidente {

    public List<Incidente> obtenerIncidente(EntityManager entityManager){
        return entityManager.createQuery("from Incidente ").getResultList();
    }

    public void agregarIncidente(Incidente incidente, EntityManager entityManager){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(incidente);
        tx.commit();
    }

    public void update(Tecnico tecnico, EntityManager entityManager){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(tecnico);
        tx.commit();


    }


}
