package com.example.mobilaloqakompaniyasi.Repository;

import com.example.mobilaloqakompaniyasi.Entity.Addres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddresRepository extends JpaRepository<Addres,Integer> {
    Optional<Addres> findByViloyatAndTumanAndKuchaAndUy(String viloyat, String tuman, String kucha, String uy);
}
