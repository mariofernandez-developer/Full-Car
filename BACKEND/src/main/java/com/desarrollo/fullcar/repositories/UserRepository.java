package com.desarrollo.fullcar.repositories;

import com.desarrollo.fullcar.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//se conecta a la base de datos
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
