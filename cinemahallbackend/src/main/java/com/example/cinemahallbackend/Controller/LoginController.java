package com.example.cinemahallbackend.Controller;

import com.example.cinemahallbackend.Pojo.Users;
import com.example.cinemahallbackend.Repository.UsersRepository;
import com.example.cinemahallbackend.Services.Validation;
import com.example.cinemahallbackend.Services.PasswordEncoderDecoder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoderDecoder passwordEncoderDecoder;
    @Autowired
    private Validation validation;
    @CrossOrigin("http://localhost:3000/")
    @PostMapping("/logindata")
    public ResponseEntity<Object> logindata(@RequestParam("email") String email, @RequestParam("password")String password , HttpServletRequest request, Model model){
       List<Users> emailData=usersRepository.findByuserEmail(email);
       Users validData=validation.isValid(emailData,password);

       if(validData==null){
          return ResponseEntity.internalServerError().body("No Account Found");
       }else{

           return ResponseEntity.ok(validData);
       }





    }
}
