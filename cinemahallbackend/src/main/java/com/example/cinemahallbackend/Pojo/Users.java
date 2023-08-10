package com.example.cinemahallbackend.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "userstable")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "userContact")
    private String userContact;
    @Column(name = "userGender")
    private String userGender;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "userType")
    private String userType;

}
