package com.desarrollo.fullcar.controllers;

import com.desarrollo.fullcar.entities.Product;
import com.desarrollo.fullcar.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productoService;


    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() throws Exception {
        return new ResponseEntity<List<Product>>(this.productoService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, no se pudo optener. Por favor intente mas tarde.\"}");

        }

    }
    @GetMapping(value = "/busqueda")
    public String busquedaProduct(Model model, @RequestParam(value ="query",required = false)String q){
        try {
            List<Product> productos = this.productoService.findByTitle(q);
            model.addAttribute("product", productos);
            model.addAttribute("resultado",q);
            return "views/busqueda";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Product entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudo guardar. Por favor intente mas tarde.\"}");

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Product entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudo actualizar. Por favor intente mas tarde.\"}");

        }
    }

    //Metodo Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudo borrar. Por favor intente mas tarde.\"}");

        }
    }
}
