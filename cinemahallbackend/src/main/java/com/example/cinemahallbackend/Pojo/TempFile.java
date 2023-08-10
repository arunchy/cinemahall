package com.example.cinemahallbackend.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tempfile")
public class TempFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tempfileId;
    @Column(name = "filename")
    private String fileName;
}
