package com.example.cinemahallbackend.Services;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderDecoder {
    public String encodePassword(String password){
       String encodedPassword=BCrypt.hashpw(password,BCrypt.gensalt());
       return encodedPassword;


    }

}


