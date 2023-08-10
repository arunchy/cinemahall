package com.example.cinemahallbackend.Repository;

import com.example.cinemahallbackend.Pojo.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users,Integer> {
 public List<Users> findByuserEmail(String email);

}
