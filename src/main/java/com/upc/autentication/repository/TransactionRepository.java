package com.upc.autentication.repository;

import com.upc.autentication.entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    @Query("SELECT P FROM Transaction P Where P.user_code = :user_code")
    List<Transaction> findTransactionsBy(@Param("user_code") Long user_code);
}



