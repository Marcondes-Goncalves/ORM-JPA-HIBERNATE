package com.marcondes.dao;

import java.util.List;

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

    public T updateMerge(T entidade){ //salva ou atualiza

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        T entidadeSalva = entityManager.merge(entidade);
        transaction.commit();

        return entidadeSalva;

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

    public void deletarPorId(T entidade){

        Object id = HibernateUtil.getPrimaryKey(entidade);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery("DELETE FROM " + entidade.getClass().getSimpleName().toLowerCase() + " WHERE id =" + id).executeUpdate(); // deleta

        transaction.commit();
    }

    @SuppressWarnings("unchecked")
    public List<T> listar(Class<T> entidade){

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        @SuppressWarnings("rawtypes")
        List lista = entityManager.createQuery("FROM " + entidade.getName()).getResultList();

        transaction.commit();

        return lista;
    }

    public EntityManager gEntityManager(){
        return entityManager;
    }
}
