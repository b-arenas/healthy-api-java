package com.upc.autentication.business;

import com.upc.autentication.entities.Preferences;
import com.upc.autentication.entities.Transaction;
import com.upc.autentication.entities.User;
import com.upc.autentication.repository.PreferencesRepository;
import com.upc.autentication.repository.TransactionRepository;
import com.upc.autentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessTransaction {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    public String createTransaction(Transaction transaction){
        List<User> listUsers = userRepository.findUserBy(transaction.getUserCode());
        if(listUsers.size() == 0)
            return "No existe usuario";

        transactionRepository.save(transaction);

        return "Transaccion guardada";
    }

    public Transaction getTransaction(Long code){
        List<User> listUsers = userRepository.findUserBy(code);
        if(listUsers.size() == 0)
            return new Transaction();

        List<Transaction> listTransaction = transactionRepository.findTransactionsBy(code);

        if(listTransaction.size() == 0)
            return new Transaction();

        return listTransaction.get(0);

    }


}

