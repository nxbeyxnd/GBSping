package com.geekbrains.lesson5.repository;

import com.geekbrains.lesson5.model.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class RepositoryProduct implements ProductsCRUD{
    private SessionFactory factory;
    private Session session;

    @Override
    public Product addProducts(Product product) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return product;
        } catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    @Override
    public Product updateProducts(Product product) {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return product;
        } catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    @Override
    public void deleteProducts(Long id) {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

            if(session.get(Product.class, id)!=null){
                session.delete(session.get(Product.class, id));
            }
            session.getTransaction().commit();
        } catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    @Override
    public List<Product> showAllProducts() {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(products);
        } catch (Exception e) {
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return Collections.emptyList();
    }

    @Override
    public Product showById(Long id) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    public void shutdown() {
        factory.close();
    }

    public void doRollback(Session session) {
        session.getTransaction().rollback();
    }
}
