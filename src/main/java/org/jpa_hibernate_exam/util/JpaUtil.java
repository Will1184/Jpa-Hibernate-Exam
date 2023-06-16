package org.jpa_hibernate_exam.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JpaUtil {
    private static final EntityManagerFactory entityManagerFactory=buildEntityManagerFactory();
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("jpaHibernateExam");
    }
    public static EntityManager getEntityManger(){
        return entityManagerFactory.createEntityManager();
    }
}
