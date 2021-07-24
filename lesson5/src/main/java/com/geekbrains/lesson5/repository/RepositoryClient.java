package com.geekbrains.lesson5.repository;

import com.geekbrains.lesson5.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class RepositoryClient implements ClientsCRUD{
    private SessionFactory factory;
    private Session session;

    @Override
    public Client addClients(Client client) {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            return client;
        }catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    @Override
    public Client updateClients(Client client) {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    @Override
    public void deleteClient(Long id) {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

            if(session.get(Client.class, id)!=null){
                session.delete(session.get(Client.class, id));
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
    public List<Client> showAllClients() {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Client> clients = session.createQuery("SELECT c FROM Client c").getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(clients);
        }catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return Collections.emptyList();
    }

    @Override
    public Client showById(Long id) {
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Client client= session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }catch (Exception e){
            doRollback(session);
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    private void shutdown(){
        session.close();
    }

    private void doRollback(Session session){
        session.getTransaction().rollback();
    }
}
