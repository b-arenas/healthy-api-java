package com.upc.autentication.business;

import com.upc.autentication.entities.Transaction;
import com.upc.autentication.entities.TransactionDetails;
import com.upc.autentication.entities.User;
import com.upc.autentication.repository.TransactionRepository;
import com.upc.autentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BusinessTransaction {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    public String createTransaction(Transaction transaction){
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hourFormatter = new SimpleDateFormat("HH:mm:ss");

        transaction.setDate(dateFormatter.format(date));
        transaction.setHour(hourFormatter.format(date));

        if(transaction.getTransaccionDetalles().size() == 0){
            return "No hay detalles de la transacción";
        }

        List<User> listUsers = userRepository.findUserBy(transaction.getUser().getCode());

        if(listUsers.size() == 0)
            return "No existe usuario";

        List<Transaction> listTransaction = transactionRepository.findTransactionsBy(listUsers.get(0).getCode());

        if(listTransaction.size() == 0){
            transaction = transactionRepository.save(transaction);

            for (TransactionDetails x: transaction.getTransaccionDetalles()) {
                transactionRepository.update(transaction.getCode(), x.getCode());
            }
        }else{
            //Listar Transacciones por días
            TransactionDetails transactionDetailsAux = ObtenerTransactionDetail(transaction);
            List<TransactionDetails> listTransactionByDays =
                    transactionRepository.findTransactionsByDays(listTransaction.get(0).getUser().getCode());

            for (TransactionDetails x: listTransactionByDays) {
                if(transactionDetailsAux.isMonday()){
                    if(x.isMonday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
                if(transactionDetailsAux.isTuesday()){
                    if(x.isTuesday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
                if(transactionDetailsAux.isWednesday()){
                    if(x.isWednesday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
                if(transactionDetailsAux.isThursday()){
                    if(x.isThursday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
                if(transactionDetailsAux.isFriday()){
                    if(x.isFriday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
                if(transactionDetailsAux.isSaturday()){
                    if(x.isSaturday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
                if(transactionDetailsAux.isSunday()){
                    if(x.isSunday()){
                        return "No puede registrar dietas el mismo día";
                    }
                }
            }

            transaction = transactionRepository.save(transaction);

            for (TransactionDetails x: transaction.getTransaccionDetalles()) {
                transactionRepository.update(transaction.getCode(), x.getCode());
            }
        }

        return "Transacción guardada";
    }

    private TransactionDetails ObtenerTransactionDetail(Transaction transaction) {
        TransactionDetails transactionDetails = new TransactionDetails();

        for (TransactionDetails t: transaction.getTransaccionDetalles()) {
            if(!transactionDetails.isMonday()){
                if(t.isMonday()){
                    transactionDetails.setMonday(true);
                }
                else{
                    transactionDetails.setMonday(false);
                }
            }

            if(!transactionDetails.isTuesday()){
                if(t.isTuesday()){
                    transactionDetails.setTuesday(true);
                }
                else{
                    transactionDetails.setTuesday(false);
                }
            }

            if(!transactionDetails.isWednesday()){
                if(t.isWednesday()){
                    transactionDetails.setWednesday(true);
                }
                else{
                    transactionDetails.setWednesday(false);
                }
            }

            if(!transactionDetails.isThursday()){
                if(t.isThursday()){
                    transactionDetails.setThursday(true);
                }
                else{
                    transactionDetails.setThursday(false);
                }
            }

            if(!transactionDetails.isFriday()){
                if(t.isFriday()){
                    transactionDetails.setFriday(true);
                }
                else{
                    transactionDetails.setFriday(false);
                }
            }

            if(!transactionDetails.isSaturday()){
                if(t.isSaturday()){
                    transactionDetails.setSaturday(true);
                }
                else{
                    transactionDetails.setSaturday(false);
                }
            }

            if(!transactionDetails.isSunday()){
                if(t.isSunday()){
                    transactionDetails.setSunday(true);
                }
                else{
                    transactionDetails.setSunday(false);
                }
            }
        }

        return transactionDetails;
    }

    public List<Transaction> getTransaction(Long code){
        List<User> listUsers = userRepository.findUserBy(code);
        if(listUsers.size() == 0)
            return new ArrayList<>();

        List<Transaction> listTransaction = transactionRepository.findTransactionsBy(code);

        for (Transaction x: listTransaction) {
            x.setTransaccionesDetalles(null);
        }

        if(listTransaction.size() == 0)
            return new ArrayList<>();

        return listTransaction;

    }
}

