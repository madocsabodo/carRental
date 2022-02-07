package edu.datafusion.CarRental.service;


import edu.datafusion.CarRental.models.ClientModel;
import edu.datafusion.CarRental.repositories.Client;
import edu.datafusion.CarRental.repositories.ClientRepository;
import edu.datafusion.CarRental.repositories.ClientRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientRepositoryInterface clientRepositoryInterface;

    @PersistenceContext
    private EntityManager entityManager;

    /*
    public Long findAll(){
        Long l = clientRepositoryInterface.count();
        return l;
    }
     */

    public List<ClientModel> findAll() {
        return entityManager.createQuery("select c from Client c", Client.class).getResultList().stream()
                .map(this::toClientModel)
                .collect(Collectors.toList());
    }

//findAll, add, delete tobbire is
    public ClientModel addClient(ClientModel clientModel) {
        ClientModel clientResponse = new ClientModel();
        Client client = clientRepository.addClient(toClient(clientModel));
        return toClientModel(client);
    }

    private Client toClient(ClientModel clientModel) {
        Client client = new Client();
        client.setId((long) clientModel.getId());
        client.setName(clientModel.getName());
        client.setInsuranceNumber(clientModel.getInsuranceNumber());
        client.setDateOfBirth(clientModel.getDateOfBirth());
        client.setLoyalityPoints(clientModel.getLoyalityPoints());

        return client;
    }

    private ClientModel toClientModel(Client client) {
        ClientModel clientModel = new ClientModel();
        clientModel.setId(client.getId());
        clientModel.setName(client.getName());
        clientModel.setInsuranceNumber(client.getInsuranceNumber());
        clientModel.setDateOfBirth(client.getDateOfBirth());
        clientModel.setLoyalityPoints(client.getLoyalityPoints());

        return clientModel;
    }
}
