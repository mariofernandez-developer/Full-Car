package com.desarrollo.fullcar.repositories;

import com.desarrollo.fullcar.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM  product", nativeQuery = true )
    List<Product> findAll();

    @Query(value = "SELECT * FROM  product WHERE product.id = :id ", nativeQuery = true)
    Optional<Product> findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM product WHERE product.nombre LIKE %:q%", nativeQuery = true)
    List<Product> findByTitle(@Param("q")String q);
}
