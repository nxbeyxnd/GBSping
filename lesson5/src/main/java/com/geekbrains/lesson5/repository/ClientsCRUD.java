package com.geekbrains.lesson5.repository;

import com.geekbrains.lesson5.model.Client;
import com.geekbrains.lesson5.model.Product;

import java.util.List;

public interface ClientsCRUD {
    public Client addClients(Client client);
    public Client updateClients(Client client);
    public void deleteClient(Long id);
    public List<Client> showAllClients();
    public Client showById(Long id);
}
