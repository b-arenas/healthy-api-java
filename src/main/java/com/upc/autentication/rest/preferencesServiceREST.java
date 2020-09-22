package com.upc.autentication.rest;

import com.upc.autentication.business.BusinessPreferences;
import com.upc.autentication.entities.Preferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class preferencesServiceREST {
  @Autowired
  private BusinessPreferences business;

  @GetMapping("/preferences/{code}")
  public Preferences getPreferences(@PathVariable(value = "code") Long code){
      return business.getPreferences(code);
  }

  @PostMapping("/preferences")
  public String createPreferences(@RequestBody Preferences preferences){
      String strMensaje;
      try{
          strMensaje =  business.createPreferences(preferences);
      }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo crear", e);
      }
      return strMensaje;
  }

}
