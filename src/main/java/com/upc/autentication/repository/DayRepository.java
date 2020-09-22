package com.upc.autentication.repository;
import java.util.Optional;
import com.upc.autentication.entities.Day;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DayRepository extends  CrudRepository<Day, Long> {
    @Query("SELECT P FROM Day P Where P.user_code = :user_code")
    List<Day> findDayBy(@Param("user_code") Long user_code);

}
