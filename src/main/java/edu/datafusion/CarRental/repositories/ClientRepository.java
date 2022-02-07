package edu.datafusion.CarRental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
@ApplicationScope
public class ClientRepository {
    List<Client> clients = new ArrayList<Client>();

    @PostConstruct
    public void readClients() {

    }

    public List<Client> findAll() {
        return clients;
    }

    public Client addClient(Client client) {
        clients.add(client);
        return client;
    }

    public void deleteById(int id) {
        clients.removeIf(t -> t.getId() == id);
    }

    public Client findClientById(int client_id) {
        Client searchedClient = clients.stream()
                .filter(findClient -> findClient.getId() == client_id)
                .findAny()
                .get();

        return searchedClient;
    }

}
