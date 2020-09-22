package com.upc.autentication.rest;

import com.upc.autentication.business.BusinessDay;
import com.upc.autentication.entities.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.PostUpdate;
import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class dayServiceREST {
    @Autowired
    private BusinessDay business;

    @GetMapping("/select-day/{code}")
    public Day getDay(@PathVariable(value = "code")Long code) {return business.getDay(code); }

    @PostMapping("select-day")
    public String createDay(@RequestBody Day day){
        String message;
        try{
            message = business.createDay(day);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "No se registró tus días", e);
        }
        return message;
    }


}

