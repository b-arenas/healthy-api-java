package com.upc.autentication.rest;

import com.upc.autentication.business.BusinessTransaction;
import com.upc.autentication.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class transactionServiceREST {
    @Autowired
    private BusinessTransaction business;

    @GetMapping("/transaction/{code}")
    public Transaction getTransaction(@PathVariable(value = "code") Long code){
        return business.getTransaction(code);
    }
    @PostMapping("/transaction")
    public String createTransaction(@RequestBody Transaction transaction){
        String tranMessage;
        try{
            tranMessage = business.createTransaction(transaction);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo crear transacción", e);
        }
        return tranMessage;
    }

}
