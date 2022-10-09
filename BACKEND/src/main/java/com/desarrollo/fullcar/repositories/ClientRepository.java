package com.desarrollo.fullcar.repositories;

import com.desarrollo.fullcar.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//se conecta a la base de datos
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Optional<Client> findByUsername(String username);
}
