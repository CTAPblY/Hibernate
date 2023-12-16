package org.example.hibernate.entity;


import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NumbDao {

    public void save(Numb numb){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(numb);
        tx1.commit();
        session.close();
    }

    public void update(Numb numb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(numb);
        tx1.commit();
        session.close();
    }

    public void delete(Numb numb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(numb);
        tx1.commit();
        session.close();
    }

    public List<Numb> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("SELECT a FROM Numb a", Numb.class).getResultList();
    }

}
