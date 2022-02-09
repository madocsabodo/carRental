package edu.datafusion.CarRental.service;


import edu.datafusion.CarRental.models.Client;
import edu.datafusion.CarRental.repository.ClientBE;
import edu.datafusion.CarRental.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for business operations on Client.
 */
@Transactional
@Repository
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Find all clients.
     *
     * @return list of {@link Client}.
     */
    public List<Client> findAll() {
        return clientRepository.findAll().stream()
                .map(this::toClientModel)
                .collect(Collectors.toList());
    }

    /**
     * Persist a Client entity.
     *
     * @param client the client to be persisted.
     * @return the {@link Client} which was persisted.
     */
    public Client addClient(Client client) {
        ClientBE clientBE = clientRepository.save(toClientBE(client));
        return toClientModel(clientBE);
    }

    /**
     * Delete a Client by Id.
     *
     * @param id the id of the Client.
     */
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    private ClientBE toClientBE(Client client) {
        ClientBE clientBE = new ClientBE();
        clientBE.setId(client.getId());
        clientBE.setName(client.getName());
        clientBE.setInsuranceNumber(client.getInsuranceNumber());
        clientBE.setDateOfBirth(client.getDateOfBirth());
        clientBE.setLoyaltyPoints(client.getLoyalityPoints());

        return clientBE;
    }

    private Client toClientModel(ClientBE clientBE) {
        Client client = new Client();
        client.setId(clientBE.getId());
        client.setName(clientBE.getName());
        client.setInsuranceNumber(clientBE.getInsuranceNumber());
        client.setDateOfBirth(clientBE.getDateOfBirth());
        client.setLoyalityPoints(clientBE.getLoyaltyPoints());

        return client;
    }

    public List<Client> findClientsInLoyaltyPointInterval(int min, int max) {
        return clientRepository.findClientsInLoyalityPointInterval(min, max)
                .stream()
                .map(this::toClientModel)
                .collect(Collectors.toList());
    }
}
