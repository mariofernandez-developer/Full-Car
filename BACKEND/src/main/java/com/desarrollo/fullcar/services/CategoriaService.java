package com.desarrollo.fullcar.services;

import com.desarrollo.fullcar.entities.Categoria;
import com.desarrollo.fullcar.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements BaseService<Categoria> {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        try {
            List<Categoria> categorias = this.categoriaRepository.findAll();
            return categorias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria findById(Long id) throws Exception {
        try {
            Optional<Categoria> opt = this.categoriaRepository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria save(Categoria entity) throws Exception {
        try{
            entity = categoriaRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria update(Long id, Categoria entity) throws Exception {
        try{
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            Categoria categoria = entityOptional.get();
            categoria = categoriaRepository.save(categoria);
            return categoria;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(categoriaRepository.existsById(id)){
                categoriaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
