package com.upc.autentication.repository;

import com.upc.autentication.entities.Transaction;
import com.upc.autentication.entities.TransactionDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    @Query("SELECT P FROM Transaction P Where P.user.code = :user_code")
    List<Transaction> findTransactionsBy(@Param("user_code") Long user_code);

    @Query("SELECT TD FROM TransactionDetails TD INNER JOIN Transaction T " +
            "On TD.transaction.code = T.code " +
            "Where T.user.code = :user_code")
    List<TransactionDetails> findTransactionsByDays(@Param("user_code") Long user_code);

    @Modifying
    @Transactional
    @Query("UPDATE TransactionDetails TD SET TD.transaction.code = :transaction_code Where TD.code = :code")
    void update(@Param("transaction_code") Long transaction_code, @Param("code") Long code);
}



