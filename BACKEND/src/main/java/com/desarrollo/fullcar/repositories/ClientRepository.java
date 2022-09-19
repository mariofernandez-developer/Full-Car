package com.desarrollo.fullcar.repositories;

import com.desarrollo.fullcar.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//se conecta a la base de datos
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
