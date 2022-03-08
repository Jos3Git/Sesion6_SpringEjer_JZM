package com.example.DAO;

import com.example.model.Resource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ResourceDAOImpl implements ResourceDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Resource> findAllEntityManager(){
        String jpql = "select r from Resource r";
        return this.entityManager.createQuery(jpql, Resource.class).getResultList();
    }
}
