package com.example.mobilaloqakompaniyasi.AdditionalData;

import com.example.mobilaloqakompaniyasi.Entity.Lavozim;
import com.example.mobilaloqakompaniyasi.Entity.Users;
import com.example.mobilaloqakompaniyasi.Repository.LavozimRepository;
import com.example.mobilaloqakompaniyasi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.mobilaloqakompaniyasi.AdditionalData.Huquqlar.*;

@Component
public class AutoLoader implements CommandLineRunner {
    @Value(value = "${spring.sql.init.mode}")
    String firstLoad;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LavozimRepository lavozimRepository;



    @Override
    public void run(String... args) throws Exception {
        if(firstLoad.equals("always")) {
            Huquqlar[] values = Huquqlar.values();
            Lavozim direktor = lavozimRepository.save(new Lavozim(
                    LavozimConst.DIREKTOR,
                    Arrays.asList(values),
                    "Direktor"
            ));
            Lavozim hodim = lavozimRepository.save(new Lavozim(
                    LavozimConst.HODIM,
                    Arrays.asList(values),
                    "Hodim"
            ));
            Lavozim user = lavozimRepository.save(new Lavozim(
                    LavozimConst.USER,
                    Arrays.asList(READTARIF),
                    "User"
            ));
            Users user1=userRepository.save(new Users(
                    "Azamat","Ramizov","Oybek o'g'li","Azamatbek",passwordEncoder.encode("0000"),direktor,true
            ));
        }
    }
}
