package com.upc.autentication.repository;

import com.upc.autentication.entities.Preferences;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferencesRepository extends CrudRepository<Preferences, Long> {
    @Query("SELECT P FROM Preferences P Where P.code = :user_code")
    List<Preferences> findPreferencesBy(@Param("user_code") Long user_code);
}
