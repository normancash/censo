package org.example.censo.service;

import javax.persistence.EntityManager;
import java.util.List;

public interface IDAO {

   <T> List<T> getAll(EntityManager em, String namedQuery, Class<T> clazz);

   <T> T findById(EntityManager em,Class<T> clazz,Integer id);

   <T> void remove(EntityManager em,T entity);

   <T> void create(EntityManager em, T entity);

   <T> T update(EntityManager em,T entity);


}
