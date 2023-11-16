package org.example.censo.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerAdmin {
    private static EntityManager instance;
    private static final String UNIDAD = "default";
    public static EntityManager getInstance() {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory(UNIDAD);
            return emf.createEntityManager();
    }

    private EntityManagerAdmin(){}
}
