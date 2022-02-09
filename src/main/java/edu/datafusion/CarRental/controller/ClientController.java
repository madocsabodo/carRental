package edu.datafusion.CarRental.controller;

import edu.datafusion.CarRental.models.Client;
import edu.datafusion.CarRental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> listClients(){
        return clientService.findAll();
    }

    @GetMapping
    public List<Client> findClientsInLoyaltyPointInterval(){
        return clientService.findAll();
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
