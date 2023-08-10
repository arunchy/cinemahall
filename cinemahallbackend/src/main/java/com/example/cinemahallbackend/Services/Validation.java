package com.example.cinemahallbackend.Services;

import com.example.cinemahallbackend.Pojo.Users;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Validation {
public Users isValid(List<Users> lists,String password){
    for(Users list:lists){
        String encodedPassword=list.getUserPassword();
        if(BCrypt.checkpw(password,encodedPassword)){
            return list;
        }

    }
    return null;
}
}
