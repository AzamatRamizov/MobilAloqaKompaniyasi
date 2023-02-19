package com.example.mobilaloqakompaniyasi.Service;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Entity.Tarif;
import com.example.mobilaloqakompaniyasi.Repository.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarifService {
    @Autowired
    TarifRepository tarifRepository;
    public APIResponse add(Tarif tarif) {
        boolean b = tarifRepository.existsByNomi(tarif.getNomi());
        if(!b){
            tarifRepository.save(tarif);
            return new APIResponse("Tarif added succesfully",true);
        }
        return new APIResponse("Not added",false);
    }

    public APIResponse edit(Integer id, Tarif tarif) {
        Optional<Tarif> byId = tarifRepository.findById(id);
        if(byId.isPresent()){
            Tarif tarif1 = byId.get();
            tarif1.setNomi(tarif.getNomi());
            tarif1.setNarxi(tarif.getNarxi());
            tarif1.setMuddat(tarif.getMuddat());
            tarifRepository.save(tarif1);
            return new APIResponse("Tarif edited",true);
        }
        return new APIResponse("Id not found",false);
    }

    public APIResponse delete(Integer id) {
        Optional<Tarif> byId = tarifRepository.findById(id);
        if(byId.isPresent()){
            tarifRepository.deleteById(id);
            return new APIResponse("Deleted",true);
        }
        return new APIResponse("Id not found",false);

    }

    public APIResponse read(Integer id) {
        Optional<Tarif> byId = tarifRepository.findById(id);
        if(byId.isPresent()){
            Tarif tarif = byId.get();
            return new APIResponse(tarif.toString(),true);
        }
        return new APIResponse("Not found",false);
    }
}
