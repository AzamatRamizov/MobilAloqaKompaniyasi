package com.example.mobilaloqakompaniyasi.Repository;

import com.example.mobilaloqakompaniyasi.Entity.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarifRepository extends JpaRepository<Tarif,Integer> {
    boolean existsByNomi(String nomi);
    Optional<Tarif> findByNomi(String nomi);
}
