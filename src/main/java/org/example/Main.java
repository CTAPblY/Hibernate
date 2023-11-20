package org.example;

import org.example.hibernate.entity.Numb;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
        Numb numb = new Numb(21, "+55", "Brazil");

//
//        transaction = session.beginTransaction();
//
//        session.save(numb);
//
//        transaction.commit();
//
//        if (transaction == null)
//            System.out.println("true");
//
//        session.close();
//        HibernateUtil.shutdown();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(numb);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List< Numb > students = session.createQuery("from Numb", Numb.class).list();
            students.forEach(s -> System.out.println(s.getNumb()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}