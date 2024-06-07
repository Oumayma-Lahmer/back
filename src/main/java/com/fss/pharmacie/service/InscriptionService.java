package com.fss.pharmacie.service;


import com.fss.pharmacie.models.*;
import com.fss.pharmacie.repository.AdminRepository;
import com.fss.pharmacie.repository.ClientRepository;
import com.fss.pharmacie.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void inscrireUtilisateur(InscriptionDTO inscriptionDTO) {
        if ("client".equalsIgnoreCase(inscriptionDTO.getRole())) {
            inscrireClient(inscriptionDTO);
        } else if ("employe".equalsIgnoreCase(inscriptionDTO.getRole())) {
            inscrireEmploye(inscriptionDTO);
        }
        else {
            throw new IllegalArgumentException("Rôle non valide pour l'inscription.");
        }
    }

    private void inscrireClient(InscriptionDTO inscriptionDTO) {
        Client client = new Client(inscriptionDTO.getNom(), inscriptionDTO.getPrenom(),
                inscriptionDTO.getEmail(), passwordEncoder.encode(inscriptionDTO.getPassword()),
                inscriptionDTO.getAdresse(), inscriptionDTO.getTelephone(),
                inscriptionDTO.getFidelite());
        clientRepository.save(client);

    }

    private void inscrireEmploye(InscriptionDTO inscriptionDTO) {
        Employe employe = new Employe(inscriptionDTO.getNom(), inscriptionDTO.getPrenom(),
                inscriptionDTO.getEmail(), passwordEncoder.encode(inscriptionDTO.getPassword()),
                inscriptionDTO.getAdresse(), inscriptionDTO.getTelephone(),
                inscriptionDTO.getExperience());
        employeRepository.save(employe);
    }

    public Connexion connecterUtilisateur(Connexion connexion) {

        // Vérifier les informations d'identification, comparer les mots de passe, etc.
        Client client = clientRepository.findByEmail(connexion.getEmail());
        if (client != null && passwordEncoder.matches(connexion.getPassword(), client.getPassword())) {
            connexion.setRole("client");
            return connexion;
        }

        Employe employe = employeRepository.findByEmail(connexion.getEmail());
        if (employe != null && passwordEncoder.matches(connexion.getPassword(), employe.getPassword())) {
            connexion.setRole("employe");
            return connexion;
        }
        // Vérifier si l'utilisateur est un administrateur
        Admin admin = adminRepository.findByEmail(connexion.getEmail());
        if (admin != null && connexion.getPassword().equals(admin.getPassword())) {
            connexion.setRole("admin");
            return connexion;
        }

        // Aucune correspondance trouvée, retourner l'objet Connexion sans le rôle
        return connexion;
    }




















}
