package com.desarrollo.fullcar.services;

import com.desarrollo.fullcar.entities.Categoria;
import com.desarrollo.fullcar.entities.Product;
import com.desarrollo.fullcar.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BaseService<Product> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    @Transactional  //hace una transaccion a la base de datos
    public List<Product> findAll() throws Exception {
        try{
            List<Product> productos = (List<Product>) productRepository.findAll();
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Product findById(Long id) throws Exception {
        try{
            Optional<Product> entityOptional = productRepository.findById(id); //como no sabemos si va a haber un producto en la base de datos lo colocamos asi
            return entityOptional.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Product save(Product entity) throws Exception {
        try{
            entity = productRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Product update(Long id, Product entity) throws Exception {
        try{
            Optional<Product> entityOptional = productRepository.findById(id);
            Product product = entityOptional.get();
            product = productRepository.save(product);
            return product;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(productRepository.existsById(id)){
                productRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Product> findByTitle(String q) throws Exception{
        try{
            List<Product> entities = this.productRepository.findByTitle(q);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
