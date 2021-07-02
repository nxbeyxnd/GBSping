package com.geekbrains.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    private static SessionFactory factory;
    private static Session session;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    //Select *
    public static void showItem(Long id) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println(session.get(Product.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void createNewItem(String title, int cost) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(new Product(title, cost));
            session.getTransaction().commit();
        } catch (Exception e) {
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void deleteItem(Long id) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void updateItem(Long id, String title, int cost) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(new Product(id, title, cost));
            session.getTransaction().commit();
        } catch (Exception e) {
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void shutdown() {
        factory.close();
    }

    public static void doRollback(Session session) {
        session.getTransaction().rollback();
    }

    public static void main(String[] args) {
        init();
//        showItem(1L);
        createNewItem("chicken", 500);
//        deleteItem(4L);
//        updateItem(2L, "cheese", 10000);
    }
}
