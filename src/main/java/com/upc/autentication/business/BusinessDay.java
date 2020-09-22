package com.upc.autentication.business;

import com.upc.autentication.entities.Day;
import com.upc.autentication.entities.User;
import com.upc.autentication.repository.DayRepository;
import com.upc.autentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDay {
    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private UserRepository userRepository;

    public String createDay(Day day){
        List<User> listUsers = userRepository.findUserBy(day.getUserCode());
        if (listUsers.size() == 0)
            return  "Usuario inexistente";

        dayRepository.save(day);

        return "Selección guardada";
    }


    public Day getDay(Long code){
        List<User> listUsers = userRepository.findUserBy(code);
        if (listUsers.size()==0)
            return new Day();

        List<Day> listDay = dayRepository.findDayBy(code);

        if (listDay.size() == 0)
            return new Day();

        return listDay.get(0);
    }

}
