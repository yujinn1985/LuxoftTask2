package com.gmail.myyujinn.dao;

import com.gmail.myyujinn.model.MyFile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MyFileDAOImpl implements MyFileDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(MyFile myFile) {
        entityManager.persist(myFile);
    }

    @Override
    public List<MyFile> list() {
        TypedQuery<MyFile> query = entityManager.createQuery("SELECT m FROM MyFile m", MyFile.class);
        return query.getResultList();
    }
}
