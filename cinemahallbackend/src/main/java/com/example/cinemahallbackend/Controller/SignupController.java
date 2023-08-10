package com.example.cinemahallbackend.Controller;


import com.example.cinemahallbackend.Pojo.Users;
import com.example.cinemahallbackend.Repository.UsersRepository;
import com.example.cinemahallbackend.Services.PasswordEncoderDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SignupController {
    @Autowired
    private PasswordEncoderDecoder passwordEncoderDecoder;
    @Autowired
    private UsersRepository usersRepository;
    @CrossOrigin("http://localhost:3000/")
@PostMapping("/signupdata")
    public ResponseEntity<Object> singupValidataion(@RequestParam("name") String username, @RequestParam("email") String useremail, @RequestParam("contact") String usercontact, @RequestParam("gender")String usergender, @RequestParam("usertype") String usertype, @RequestParam("password")String userpassword){
    Users data=new Users();
    data.setUserName(username);
    data.setUserEmail(useremail);
    data.setUserType(usertype);
    data.setUserGender(usergender);
    String encodedPassword=passwordEncoderDecoder.encodePassword(userpassword);
    data.setUserPassword(encodedPassword);
    data.setUserContact(usercontact);
    Users savedData=usersRepository.save(data);
    return ResponseEntity.ok(savedData);

}


}
