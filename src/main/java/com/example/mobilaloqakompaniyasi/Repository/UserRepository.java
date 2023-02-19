package com.example.mobilaloqakompaniyasi.Repository;

import com.example.mobilaloqakompaniyasi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsername(String username);
}
