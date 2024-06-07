package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Client;
import com.fss.pharmacie.models.Employe;
import com.fss.pharmacie.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
    public List<Client> getAllClient() {

        return (List<Client>) clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id){return clientRepository.findById(id);}


}
