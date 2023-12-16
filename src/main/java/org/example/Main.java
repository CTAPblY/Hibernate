package org.example;

import org.example.hibernate.entity.Numb;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        Numb numb = new Numb(21, "+55", "Brazil");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            //session.save(numb);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List< Numb > numbers = session.createQuery("from Numb", Numb.class).list();
            numbers.forEach(numbs -> System.out.printf("%-5d %-10s %-10s %n", numbs.getId(), numbs.getNumb(), numbs.getCountry()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}