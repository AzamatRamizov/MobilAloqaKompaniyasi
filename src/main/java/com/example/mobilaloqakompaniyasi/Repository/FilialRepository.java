package com.example.mobilaloqakompaniyasi.Repository;

import com.example.mobilaloqakompaniyasi.Entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilialRepository extends JpaRepository<Filial,Integer> {
    Optional<Filial> findByNom(String nom);
}
