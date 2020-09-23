package com.upc.autentication.business;

import com.upc.autentication.entities.Preferences;
import com.upc.autentication.entities.User;
import com.upc.autentication.repository.PreferencesRepository;
import com.upc.autentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessPreferences {
    @Autowired
    private PreferencesRepository preferencesRepository;

    @Autowired
    private UserRepository userRepository;

    public String createPreferences(Preferences preferences){
        List<User> listUsers = userRepository.findUserBy(preferences.getCode());
        if(listUsers.size() == 0)
            return "No existe usuario";

        preferencesRepository.save(preferences);

        return "Preferencia guardada";
    }

    public Preferences getPreferences(Long code){
        List<User> listUsers = userRepository.findUserBy(code);
        if(listUsers.size() == 0)
            return new Preferences();

        List<Preferences> listPreferences = preferencesRepository.findPreferencesBy(code);

        if(listPreferences.size() == 0)
            return new Preferences();

        return listPreferences.get(0);

    }



}
