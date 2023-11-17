package org.example.censo.service;


import org.openxava.jpa.XPersistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerAdmin {
    private static EntityManager instance;
    private static final String UNIDAD = "default";
    public static EntityManager getInstance() {
            EntityManager em = XPersistence.getManager();
            if (em == null) {
                em = XPersistence.createManager();
            }
            return em;
    }

    private EntityManagerAdmin(){}
}
