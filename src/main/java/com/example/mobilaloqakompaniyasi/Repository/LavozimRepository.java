package com.example.mobilaloqakompaniyasi.Repository;

import com.example.mobilaloqakompaniyasi.Entity.Lavozim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LavozimRepository extends JpaRepository<Lavozim,Integer> {
    Optional<Lavozim> findByNomi(String nomi);
}
