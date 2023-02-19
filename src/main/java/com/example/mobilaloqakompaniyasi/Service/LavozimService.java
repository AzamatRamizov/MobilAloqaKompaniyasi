package com.example.mobilaloqakompaniyasi.Service;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Entity.Lavozim;
import com.example.mobilaloqakompaniyasi.Repository.LavozimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LavozimService {

    @Autowired
    LavozimRepository lavozimRepository;

    public APIResponse add(Lavozim lavozim) {
        Optional<Lavozim> byNomi = lavozimRepository.findByNomi(lavozim.getNomi());
        if(!byNomi.isPresent()){
            lavozimRepository.save(lavozim);
            return new APIResponse("Lavozim added succesfully",true);
        }
        return new APIResponse("Lavozim already exist",false);
    }

    public APIResponse edit(Lavozim lavozim, String nomi) {
        Optional<Lavozim> byNomi = lavozimRepository.findByNomi(nomi);
        if(byNomi.isPresent()){
            Lavozim lavozim1 = byNomi.get();
            lavozim1.setNomi(lavozim.getNomi());
            lavozim1.setHuquqlar(lavozim.getHuquqlar());
            lavozim1.setIzoh(lavozim.getIzoh());
            lavozimRepository.save(lavozim1);
            return new APIResponse("Lavozim edited",true);
        }
        return new APIResponse("Lavozim not found",false);
    }

    public APIResponse del(String nomi) {
        Optional<Lavozim> byNomi = lavozimRepository.findByNomi(nomi);
        if (byNomi.isPresent()){
            Lavozim lavozim = byNomi.get();
            lavozimRepository.deleteById(lavozim.getId());
            return new APIResponse("Lavozim deleted",true);
        }
        return new APIResponse("Lavozim not found",false);
    }

    public APIResponse read(String nomi) {
        Optional<Lavozim> byNomi = lavozimRepository.findByNomi(nomi);
        if(byNomi.isPresent()){
            Lavozim lavozim = byNomi.get();
            return new APIResponse(lavozim.toString(),true);
        }
        return new APIResponse("Lavozim not found",false);
    }
}
