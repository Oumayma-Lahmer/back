package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Client;
import com.fss.pharmacie.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService= clientService;
    }
    @GetMapping("/list")
    public List<Client> getAllClient(){
        return (List<Client>) clientService.getAllClient();
    }
    @PostMapping("/save")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
         clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }
}
