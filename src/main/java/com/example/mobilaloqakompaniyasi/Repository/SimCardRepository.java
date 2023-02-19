package com.example.mobilaloqakompaniyasi.Repository;

import com.example.mobilaloqakompaniyasi.Entity.SimCard;
import com.example.mobilaloqakompaniyasi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimCardRepository extends JpaRepository<SimCard,Integer> {
    Optional <SimCard> findByUsers(Users users);
}
