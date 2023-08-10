package com.example.cinemahallbackend.Pojo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    private String movieName;
    private String movieDescription;
    private String movieLink;
    private String moviePrice;
    private String movieType;
    private String moviePicture;
    @Column(nullable = true)
    private String[] seatList;
}
