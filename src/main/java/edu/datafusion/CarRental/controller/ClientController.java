package edu.datafusion.CarRental.controller;

import edu.datafusion.CarRental.models.Client;
import edu.datafusion.CarRental.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> listClients() {
        return clientService.findAll();
    }

    @GetMapping("findClientsInLoyaltyPointInterval")
    @ApiOperation(value = "Get All Clients based on loyalty points interval ", authorizations = {@Authorization(value = "basicAuth")})
    public List<Client> findClientsInLoyaltyPointInterval(@Param(value = "min") int min, @Param(value = "max") int max) {
        return clientService.findClientsInLoyaltyPointInterval(min, max);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
