package com.desarrollo.fullcar.services;

import com.desarrollo.fullcar.entities.Client;
import com.desarrollo.fullcar.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements BaseService<Client> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional  //hace una transaccion a la base de datos
    public List<Client> findAll() throws Exception {
        try{
            List<Client> entidades = clientRepository.findAll();
            return entidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Client findById(Long id) throws Exception {
        try{
            Optional<Client> entityOptional = clientRepository.findById(id); //como no sabemos si va a haber un registro en la base de datos lo colocamos asi
            return entityOptional.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Client save(Client entity) throws Exception {
        try{
            entity = clientRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Client update(Long id, Client entity) throws Exception {
        try{
            Optional<Client> entityOptional = clientRepository.findById(id);
            Client client = entityOptional.get();
            client = clientRepository.save(client);
            return client;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(clientRepository.existsById(id)){
                clientRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
