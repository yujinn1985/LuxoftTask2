package com.gmail.myyujinn.dao;

import org.springframework.stereotype.Repository;
import com.gmail.myyujinn.model.MyLine;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MyLineDAOImpl implements MyLineDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MyLine> list() {
        TypedQuery<MyLine> query = entityManager.createQuery("SELECT m FROM MyLine m", MyLine.class);
        return query.getResultList();
    }

    @Override
    public List<MyLine> listLinesFromFile(long num) {
        TypedQuery<MyLine> query = entityManager.createQuery("SELECT m FROM MyLine m WHERE m.myFile.id=:file", MyLine.class);
        query.setParameter("file", num);
        return query.getResultList();
    }

    @Override
    public List<MyLine> listOfFilteredFiles() {
        TypedQuery<MyLine> query = entityManager.createQuery("SELECT m FROM MyLine m WHERE m.myFile.totalLines>=10", MyLine.class);
        return query.getResultList();
    }
}
