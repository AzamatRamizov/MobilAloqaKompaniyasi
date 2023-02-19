package com.example.mobilaloqakompaniyasi.Service;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.SimDto;
import com.example.mobilaloqakompaniyasi.Entity.SimCard;
import com.example.mobilaloqakompaniyasi.Entity.Tarif;
import com.example.mobilaloqakompaniyasi.Entity.Users;
import com.example.mobilaloqakompaniyasi.Repository.SimCardRepository;
import com.example.mobilaloqakompaniyasi.Repository.TarifRepository;
import com.example.mobilaloqakompaniyasi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SimCardRepository simCardRepository;
    @Autowired
    TarifRepository tarifRepository;

    public APIResponse add(SimDto simDto) {
        if(!(simDto.getOperatorKod()==90||simDto.getOperatorKod()==91)){
            return new APIResponse("Operator Code is invalid",false);
        }
        Optional<Tarif> byNomi = tarifRepository.findByNomi(simDto.getTarif());
        if(!byNomi.isPresent()){
            return new APIResponse("Tarif is not",false);
        }
        Optional<Users> byUsername = userRepository.findByUsername(simDto.getUsername());
        if(!byUsername.isPresent()){
            return new APIResponse("User not found",false);
        }
        Users users = byUsername.get();
        SimCard simCard = new SimCard();
        simCard.setRaqam(910000000+simDto.getRaqam());
        simCard.setBalans(simDto.getBalans());
        Tarif tarif = byNomi.get();
        simCard.setTarif(tarif);
        simCard.setUsers(users);
        simCardRepository.save(simCard);
        return new APIResponse("Sim Card added succesfully",true);
    }
}
