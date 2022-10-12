package com.desarrollo.fullcar.services;

import com.desarrollo.fullcar.entities.User;
import com.desarrollo.fullcar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional  //hace una transaccion a la base de datos
    public List<User> findAll() throws Exception {
        try{
            List<User> entidades = (List<User>) userRepository.findAll();
            return entidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User findById(Long id) throws Exception {
        try{
            Optional<User> entityOptional = userRepository.findById(id); //como no sabemos si va a haber un registro en la base de datos lo colocamos asi
            return entityOptional.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User save(User entity) throws Exception {
        try{
            entity = userRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User update(Long id, User entity) throws Exception {
        try{
            Optional<User> entityOptional = userRepository.findById(id);
            User user = entityOptional.get();
            user = userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(userRepository.existsById(id)){
                userRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
