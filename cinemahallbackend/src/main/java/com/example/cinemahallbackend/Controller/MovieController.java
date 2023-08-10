package com.example.cinemahallbackend.Controller;

import com.example.cinemahallbackend.Pojo.Movies;
import com.example.cinemahallbackend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin("http://localhost:3000/")
    @PostMapping("/addmovie")
    public ResponseEntity<Object> addMovies(@RequestParam("name")String movieName, @RequestParam("description")String moveDescription, @RequestParam("link")String movieLink, @RequestParam("price")String moviePrice, @RequestParam("type")String movieType, @RequestParam("picture")String moviePicture){
        Movies data=new Movies();
        data.setMovieName(movieName);
        data.setMovieDescription(moveDescription);
        data.setMovieLink(movieLink);
        data.setMoviePrice(moviePrice);
        data.setMovieType(movieType);
        data.setMoviePicture(moviePicture);
        Movies savedData=movieRepository.save(data);
        return ResponseEntity.ok(savedData);
    }
    @CrossOrigin("http://localhost:3000/")
    @GetMapping("/getmovies")
    public ResponseEntity<Object> getallMovies(){
         Iterable<Movies>allData=movieRepository.findAll();
         return ResponseEntity.ok(allData);
    }


}
