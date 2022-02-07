package edu.datafusion.CarRental.controller;

import edu.datafusion.CarRental.models.ClientModel;
import edu.datafusion.CarRental.repositories.ClientRepository;
import edu.datafusion.CarRental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientModel> listClients(){
        return clientService.findAll();
    }

    @PostMapping
    public ClientModel addClient(@RequestBody ClientModel clientModel) {
        return clientService.addClient(clientModel);
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable int id) {
        clientRepository.deleteById(id);
    }
}
