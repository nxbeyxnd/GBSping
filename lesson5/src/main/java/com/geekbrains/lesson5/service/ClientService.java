package com.geekbrains.lesson5.service;

import com.geekbrains.lesson5.model.Client;
import com.geekbrains.lesson5.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    RepositoryClient repositoryClient;

    public List<Client> getAllClients(){
        return repositoryClient.showAllClients();
    }

    public Client addClient(Client client){
        return repositoryClient.addClients(client);
    }

    public Client updateClient(Client client){
        return repositoryClient.updateClients(client);
    }

    public void deleteClient(Long id){
        repositoryClient.deleteClient(id);
    }

    public Client findById(Long id){
        return repositoryClient.showById(id);
    }
}
