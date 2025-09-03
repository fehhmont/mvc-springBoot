package com.mvc.boot.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class AbstractDao<T, pk extends Serializable> {

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass =
                    (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager gEntityManager() {
        return entityManager;
    }

    public void save(T entity){
        entityManager.persist(entity);
    }

    public void update(T entity){
        entityManager.merge(entity);

    }

    public void delete(PK id){
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public T findById(PK id){
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll(){
        return entityManager
                .createQuery("form" + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params){
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for ( int i = 0; i < params.length; i++){
            query.setParameter(i + 1, params[i]);
        }

        return query.getResultList();
    }
}
