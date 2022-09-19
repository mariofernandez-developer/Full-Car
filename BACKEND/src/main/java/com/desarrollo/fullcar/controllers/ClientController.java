package com.desarrollo.fullcar.controllers;

import com.desarrollo.fullcar.entities.Client;
import com.desarrollo.fullcar.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //dar el acceso a la api desde distintos origenes
@RequestMapping(path = "api/v1/clients")
public class ClientController {

     @Autowired
    private ClientService clientService;

     @GetMapping("")
     public ResponseEntity<?> getAll(){
         try{
             return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
         }catch(Exception e){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje en json
         }
     }
     //get one corresponde con el metodo find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
         try{
             return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, no se pudo optener. Por favor intente mas tarde.\"}");

         }

    }
    //metodo save que responde al metodo save del servicio
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Client entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clientService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudo guardar. Por favor intente mas tarde.\"}");

        }

    }
    //MEtodo update
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Client entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudo actualizar. Por favor intente mas tarde.\"}");

        }
    }

    //Metodo Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudo borrar. Por favor intente mas tarde.\"}");

        }
    }
}
