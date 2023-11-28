package org.main;

import org.main.repositorios.RepositorioIncidente;
import org.main.repositorios.RepositorioServicio;
import org.main.repositorios.RepositorioTecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        EntityManager  entityManager = Persistence.createEntityManagerFactory("simple-persistence-unit").createEntityManager();
        RepositorioTecnico repositorioTecnico = new RepositorioTecnico();
        RepositorioIncidente repositorioIncidente = new RepositorioIncidente();

        List<Tecnico> tecnicos = repositorioTecnico.obtenerTecnicos(entityManager);

        for (Tecnico tecnico1 : tecnicos) {
            List<Especialidad> especialidadList = tecnico1.getEspecialidades();
            for (Especialidad especialidad : especialidadList){
                System.out.println(especialidad.getNombre());
            }

        }

    }
}
