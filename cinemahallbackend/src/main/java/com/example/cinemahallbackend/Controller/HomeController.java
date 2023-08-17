package com.example.cinemahallbackend.Controller;


import com.example.cinemahallbackend.Pojo.Movies;
import com.example.cinemahallbackend.Pojo.Users;
import com.example.cinemahallbackend.Repository.MovieRepository;
import com.example.cinemahallbackend.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MovieRepository movieRepository;
    @CrossOrigin("http://localhost:3000/")
    @GetMapping("/getUserData/{userId}")
    public ResponseEntity<Object> getUserData(@PathVariable String userId){
        int id=Integer.parseInt(userId);
    Users userData=usersRepository.findById(id).orElse(null);
        if(userData==null){
            ResponseEntity.internalServerError();
        }
        return  ResponseEntity.ok(userData);
    }
    @CrossOrigin("http://localhost:3000/")
    @GetMapping("/getAllMovies")
    public ResponseEntity<Iterable<Movies>> getAllMovies(){
        Iterable<Movies> moviesData=movieRepository.findAll();
        if(moviesData==null){
            ResponseEntity.internalServerError();
        }
        return ResponseEntity.ok(moviesData);

    }





}
