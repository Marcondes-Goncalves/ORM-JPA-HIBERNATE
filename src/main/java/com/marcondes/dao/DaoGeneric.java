package com.marcondes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.marcondes.HibernateUtil;

public class DaoGeneric<T> {
    
    private EntityManager entityManager = HibernateUtil.gEntityManager();

    public void salvar(T entidade){

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(entidade);
        transaction.commit();

    }
}
