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

    public T pesquisar(T entidade){

        Object id = HibernateUtil.getPrimaryKey(entidade);

        @SuppressWarnings("unchecked")
        T t = (T) entityManager.find(entidade.getClass(), id);

        return t;
    }

    public T pesquisar(Long id, Class<T> entidade){

        T t = (T) entityManager.find(entidade, id);
        return t;
    }
}
